package com.codenfast.developersuniverse.discord;

import com.codenfast.developersuniverse.configs.CommonModelConfig;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class DiscordApplication extends CommonModelConfig {
    static {
        System.setProperty("java.awt.headless", "false");
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("tr", "TR"));
        System.setProperty("file.encoding", "UTF-8");
        log.info("Default Locale:{}", Locale.getDefault());
        log.info("Default Charset:{}", Charset.defaultCharset());
        log.info("file.encoding:{}", System.getProperty("file.encoding"));
        log.info("sun.jnu.encoding:{}", System.getProperty("sun.jnu.encoding"));
        log.info("Default Encoding:{}", new InputStreamReader(new ByteArrayInputStream(new byte[]{'D'})).getEncoding());
        new SpringApplicationBuilder(DiscordApplication.class).headless(Boolean.FALSE).run(args);
    }

    @Bean
    public MappingJackson2HttpMessageConverter converter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);// will remove value properties
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
        return mapper;
    }
}

