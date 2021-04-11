package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

}
