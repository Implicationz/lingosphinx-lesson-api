package com.lingosphinx.lesson.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class FeignClientConfiguration {
    @Bean
    public RequestInterceptor jwtRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                var authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication != null && authentication.getCredentials() instanceof Jwt) {
                    var jwt = (Jwt) authentication.getCredentials();
                    template.header("Authorization", "Bearer " + jwt.getTokenValue());
                }
            }
        };
    }
}