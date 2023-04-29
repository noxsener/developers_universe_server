package com.codenfast.developersuniverse.browserbot;

import com.codenfast.developersuniverse.configs.CommonModelConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@EnableScheduling
public class BrowserBotApplication extends CommonModelConfig {

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
        new SpringApplicationBuilder(BrowserBotApplication.class).headless(Boolean.FALSE).run(args);
    }
}
