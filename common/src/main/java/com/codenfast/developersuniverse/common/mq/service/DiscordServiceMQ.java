package com.codenfast.developersuniverse.common.mq.service;

import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@Data
public class DiscordServiceMQ {

    private final AmqpTemplate amqpTemplate;

    public DiscordServiceMQ(AmqpTemplate discordServiceMQTemplate) {
        this.amqpTemplate = discordServiceMQTemplate;
    }

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("mqDiscordServiceExchange", "mqDiscordServiceQueueSendMessage", message);
    }
    public void mediaDownload(MediaDto mediaDto) {
        amqpTemplate.convertAndSend("mqDiscordServiceExchange", "mqDiscordServiceQueueMediaDownload", mediaDto);
    }
}
