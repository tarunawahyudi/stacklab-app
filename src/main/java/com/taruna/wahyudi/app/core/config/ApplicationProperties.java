package com.taruna.wahyudi.app.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String name;
    private String timeZone;
    private String relativePath;
    private Api api;

    @Getter
    @Setter
    public static class Api {
        private String uri;
    }
}
