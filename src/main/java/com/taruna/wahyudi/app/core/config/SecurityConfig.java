package com.taruna.wahyudi.app.core.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SneakyThrows
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.inMemoryAuthentication();
    }

    @SneakyThrows
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
            httpSecurity.authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(
                            "/swagger-ui.html",
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/swagger-resources/**",
                            "/webjars/**"
                    ).permitAll()
                    .anyRequest().authenticated());

            return httpSecurity.build();
    }
}
