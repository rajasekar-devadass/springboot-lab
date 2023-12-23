package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MyConfig {

    private final static String REST_SERVER_URL = "http://localhost:9090/student";

    @Bean
    public WebClient studentRestWebClient(){
        return WebClient.create(REST_SERVER_URL);
    }
}
