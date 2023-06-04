package com.example.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class ConsumingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumingService.class);

    @Autowired
    private RestTemplate rest;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    public String serviceUrl() {
//        List<ServiceInstance> list = discoveryClient.getInstances("RestService");
//        if (list != null && list.size() > 0) {
//
//            System.out.println("Found RestService..");
//
//            String host = list.get(0).getHost();
//            int port = list.get(0).getPort();
//
//            System.out.println("Returning RestService host "+host+" and port " + port);
//
//            return "http://" + host + ":" + port;
//        }
//
//        System.out.println("Could not find any RestService");
//        return null;
//    }

    public String getUser(String user) {
        String endpoint = "http://restservice:8080/service/sayHello/{user}";
        //String user = sampleEntity.get().getSurname();
        String response = rest.exchange(endpoint, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, user).getBody();
        LOGGER.info("Response: {}", response);
        return "Response Received as " + response + " -  " + new Date();
    }

}
