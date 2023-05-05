package com.codenfast.developersuniverse.discord.discord;

import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.utils.StringProcess;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.w3c.dom.Text;

@Component
@Slf4j
public class DiscordServiceImpl implements CommandLineRunner {

    @Value("${discord.token}")
    private String discordToken;

    private JDA jda;

    private final DiscordEventListener discordEventListener;
    private final ObjectMapper objectMapper;

    // Constructor injection
    public DiscordServiceImpl(DiscordEventListener discordEventListener, ObjectMapper objectMapper) {
        this.discordEventListener = discordEventListener;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        jda = JDABuilder.createDefault(discordToken)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .addEventListeners(discordEventListener)
                .build().awaitReady();
    }

    @RabbitListener(queues = "mqDiscordServiceQueueMediaDownload")
    @SendTo("mqDiscordServiceQueueMediaDownloadResult")
    public void mediaDownloadResult(MediaDto mediaDto) throws JsonProcessingException {
        try {
            if (jda == null) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    boolean ignored = Thread.interrupted();
                }
                mediaDownloadResult(mediaDto);
            }
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Download-Manager", null);
            if(mediaDto.getMimeType().startsWith("image/")) {
                embed.setImage(mediaDto.getDownloadedUrl());
            } else if(ObjectUtils.isNotEmpty(mediaDto.getMediaImage()) && StringUtils.isNotBlank(mediaDto.getMediaImage().getDownloadedUrl())) {
                embed.setImage(mediaDto.getMediaImage().getDownloadedUrl());
            }

            if (ObjectUtils.isNotEmpty(mediaDto.getDownloadIntent()) && StringUtils.isNotBlank(mediaDto.getDownloadIntent().getName())) {
                embed.setDescription(mediaDto.getDownloadIntent().getName());
            }
            if (StringUtils.isNotBlank(mediaDto.getArtist())) {
                embed.addField("Artist", mediaDto.getArtist(), Boolean.TRUE);
            }
            if (StringUtils.isNotBlank(mediaDto.getName())) {
                embed.addField("Name", mediaDto.getName(), Boolean.TRUE);
            }
            if (ObjectUtils.isNotEmpty(mediaDto.getSize())) {
                embed.addField("Size", StringProcess.formatSize(mediaDto.getSize()), Boolean.TRUE);
            }
            if (ObjectUtils.isNotEmpty(mediaDto.getMimeType())) {
                embed.addField("Type", mediaDto.getMimeType(), Boolean.TRUE);
            }
            if (ObjectUtils.isNotEmpty(mediaDto.getDownloadedUrl())) {
                embed.addField("Downloaded URL", mediaDto.getDownloadedUrl(), Boolean.FALSE);
            }
            if (ObjectUtils.isNotEmpty(mediaDto.getMediaDownloadSource())) {
                String text = mediaDto.getMediaDownloadSource().getTitle();
                if(StringUtils.isBlank(text) && StringUtils.isNotBlank(mediaDto.getMediaDownloadSource().getSiteName())) {
                    text = mediaDto.getMediaDownloadSource().getSiteName();
                } else if(StringUtils.isBlank(text) && StringUtils.isNotBlank(mediaDto.getMediaDownloadSource().getName())) {
                    text = mediaDto.getMediaDownloadSource().getName();
                }

                /*
                String imageUrl = mediaDto.getMediaDownloadSource().getImage().getMediaImage().getId();

                embed = embed.setFooter(text, imageUrl);

                 */
            }

            TextChannel textChannel = jda.getTextChannelById("1016097914432540722");
            if (textChannel != null && textChannel.canTalk()) {
                textChannel.sendMessageEmbeds(embed.build()).queue();
            } else {
                CodenfastException codenfastException = new CodenfastException("Cannot Reach Discord Channel");
                log.error(codenfastException.getMessage(), codenfastException);
            }
        } catch (JsonProcessingException e) {
            CodenfastException codenfastException = new CodenfastException(e.getMessage(), e);
            log.error(codenfastException.getMessage(), codenfastException);
            throw e;
        }
    }

    @RabbitListener(queues = "mqDiscordServiceQueueSendMessage")
    @SendTo("mqDiscordServiceQueueSendMessageResult")
    public void sendMessage(String message) {
        if (jda == null) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                boolean ignored = Thread.interrupted();
            }
            sendMessage(message);
        }
        TextChannel textChannel = jda.getTextChannelById("1016097914432540722");
        if (textChannel != null && textChannel.canTalk()) {
            textChannel.sendMessage(message).queue();
        } else {
            CodenfastException codenfastException = new CodenfastException("Cannot Reach Discord Channel");
            log.error(codenfastException.getMessage(), codenfastException);
        }
    }
}
