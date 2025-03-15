package com.springboot.Oauth2Learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/unauth-api").permitAll()
                        .anyRequest().authenticated())
                .logout(l -> l.logoutSuccessUrl("/unauth-api").permitAll())
                .oauth2Login(Customizer.withDefaults()).build();
    }
}
