package com.codenfast.developersuniverse.common.mq.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@RequiredArgsConstructor
public class MqDiscordServiceConfig {

    private final ObjectMapper objectMapper;

    @Bean("discordServiceMQTemplate")
    public AmqpTemplate discordServiceMQTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
        return rabbitTemplate;
    }

    @Bean("mqDiscordServiceExchange")
    public DirectExchange mqDiscordServiceExchange() {
        return new DirectExchange("mqDiscordServiceExchange");
    }

    @Bean("mqDiscordServiceQueueSendMessage")
    public Queue mqDiscordServiceQueueSendMessage() {
        return new Queue("mqDiscordServiceQueueSendMessage", Boolean.TRUE);
    }

    @Bean("mqDiscordServiceBindingSendMessage")
    public Binding mqDiscordServiceBindingSendMessage(Queue mqDiscordServiceQueueSendMessage, DirectExchange mqDiscordServiceExchange) {
        return BindingBuilder.bind(mqDiscordServiceQueueSendMessage).to(mqDiscordServiceExchange).with("mqDiscordServiceQueueSendMessage");
    }



    @Bean("mqDiscordServiceQueueMediaDownload")
    public Queue mqDiscordServiceQueueMediaDownload() {
        return new Queue("mqDiscordServiceQueueMediaDownload", Boolean.TRUE);
    }

    @Bean("mqDiscordServiceBindingMediaDownload")
    public Binding mqDiscordServiceBindingMediaDownload(Queue mqDiscordServiceQueueMediaDownload, DirectExchange mqDiscordServiceExchange) {
        return BindingBuilder.bind(mqDiscordServiceQueueMediaDownload).to(mqDiscordServiceExchange).with("mqDiscordServiceQueueMediaDownload");
    }



}
