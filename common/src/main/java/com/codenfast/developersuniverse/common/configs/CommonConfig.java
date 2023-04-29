package com.codenfast.developersuniverse.common.configs;

import com.codenfast.developersuniverse.configs.CommonModelConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.codenfast.developersuniverse.common.entity","com.codenfast.developersuniverse.common.entity.*"})
@ComponentScan(basePackages = {
        "com.codenfast.developersuniverse.common.mq.config",
        "com.codenfast.developersuniverse.common.mq.service"})
public class CommonConfig extends CommonModelConfig {
}
