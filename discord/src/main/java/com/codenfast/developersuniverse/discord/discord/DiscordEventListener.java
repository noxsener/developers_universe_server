package com.codenfast.developersuniverse.discord.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscordEventListener extends ListenerAdapter {

    @Value("${spring.application.name}")
    private String applicationName;

    public void initCommands(JDA jda) {
        jda.upsertCommand("ping", "Calculate ping of the bot").queue();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
//        if (event.isFromType(ChannelType.PRIVATE))
//        {
//            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),event.getMessage().getContentDisplay());
//        }
//        else
//        {
//            System.out.printf("[%s] %s: %s\n", event.getGuild().getName(),
//                    event.getMember().getEffectiveName(),
//                    event.getMessage().getContentDisplay());
//        }
        super.onMessageReceived(event);
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equals("ping")) return; // make sure we handle the right command
        long time = System.currentTimeMillis();
        event.reply("").setEphemeral(Boolean.TRUE) // reply or acknowledge
                .flatMap(v ->
                        event.getHook().editOriginalFormat("%s: %d ms", applicationName, System.currentTimeMillis() - time) // then edit original
                ).queue(); // Queue both reply and edit
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        super.onButtonInteraction(event);
    }
}
