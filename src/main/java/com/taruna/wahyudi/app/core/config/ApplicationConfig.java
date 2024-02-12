package com.taruna.wahyudi.app.core.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    protected final ApplicationProperties applicationProperties;

    public ApplicationConfig(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url(applicationProperties.getHost()))
                .addSecurityItem(new SecurityRequirement()
                .addList("API Authentication"))
                .components(new Components().addSecuritySchemes("API Authentication", createAPIKeyScheme()))
                .info(new Info()
                        .title(applicationProperties.getApi().getDocumentation().getInfo().getTitle())
                        .version(applicationProperties.getApi().getDocumentation().getInfo().getVersion())
                        .contact(new Contact()
                                .name(applicationProperties.getAuthor())
                                .email(applicationProperties.getEmail())
                                .url(applicationProperties.getUrl()))
                        .license(new License()
                                .name("License of API")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}