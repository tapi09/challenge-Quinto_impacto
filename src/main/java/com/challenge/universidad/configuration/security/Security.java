package com.challenge.universidad.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class Security {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/css/*","/js/*","/img/*","/png/*","/jpg/*","/h2-console/**","/**").permitAll()
        );
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

}
