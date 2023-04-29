package com.codenfast.developersuniverse.media;

import com.codenfast.developersuniverse.common.configs.CommonConfig;
import com.codenfast.developersuniverse.entitydto.OfflineDbInfoDto;
import com.codenfast.developersuniverse.feignclients.OfflineDbInfoFeignClient;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
@EnableAsync
public class MediaApplication extends CommonConfig {
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
        new SpringApplicationBuilder(MediaApplication.class).headless(Boolean.FALSE).run(args);
    }

    @Bean
    public CommandLineRunner init(OfflineDbInfoFeignClient offlineDbInfoFeignClient) {
        return (args) -> {
            ResponseEntity<List<OfflineDbInfoDto>> offlineDbInfoList = offlineDbInfoFeignClient.grid(RequestGrid.getByProperty("name", StringConstant.EQUAL, "Media"));
            if (Objects.nonNull(offlineDbInfoList) & CollectionUtils.isEmpty(offlineDbInfoList.getBody())) {
                OfflineDbInfoDto offlineDbInfo = new OfflineDbInfoDto();
                offlineDbInfo.setName("Media");
                offlineDbInfoFeignClient.save(offlineDbInfo);
            }
        };
    }
}
