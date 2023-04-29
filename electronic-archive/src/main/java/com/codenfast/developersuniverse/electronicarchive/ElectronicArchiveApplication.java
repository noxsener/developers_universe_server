package com.codenfast.developersuniverse.electronicarchive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Locale;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
@EnableAsync
public class ElectronicArchiveApplication {
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
        new SpringApplicationBuilder(ElectronicArchiveApplication.class).headless(Boolean.FALSE).run(args);
    }
}
