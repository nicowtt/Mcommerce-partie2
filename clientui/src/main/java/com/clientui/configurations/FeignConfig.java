package com.clientui.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class FeignConfig {

    @Bean
    public BasicAuthenticationInterceptor mBasicAuthenticationInterceptor() {
        return new BasicAuthenticationInterceptor("utilisateur", "mdp");
    }
}
