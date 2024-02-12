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
    private String author;
    private String email;
    private String url;
    private String host;
    private String timeZone;
    private String relativePath;
    private Api api;

    @Getter
    @Setter
    public static class Api {

        @Getter
        @Setter
        private String uri;
        private Documentation documentation;

        @Getter
        @Setter
        public static class Documentation {

            private Info info;
            private ExternalDoc externalDoc;

            @Getter
            @Setter
            public static class Info {
                private String title;
                private String version;
            }

            @Getter
            @Setter
            public static class ExternalDoc {
                private String description;
                private String url;
            }
        }
    }


}
