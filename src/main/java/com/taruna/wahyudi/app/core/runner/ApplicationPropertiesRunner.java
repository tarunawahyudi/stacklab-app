package com.taruna.wahyudi.app.core.runner;

import com.taruna.wahyudi.app.core.config.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ApplicationPropertiesRunner implements ApplicationRunner {

    private final ApplicationProperties properties;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(properties.getName());
        log.info(properties.getTimeZone());
    }
}
