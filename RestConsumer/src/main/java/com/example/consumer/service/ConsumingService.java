package com.example.consumer.service;

import com.example.consumer.controller.SampleController;
import io.micrometer.common.util.internal.logging.InternalLogger;
import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ConsumingService {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumingService.class);
    private InternalLogger logger = Slf4JLoggerFactory.getInstance(ConsumingService.class);

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    public String serviceUrl() {
//        List<ServiceInstance> list = discoveryClient.getInstances("restservice");
//
//        if (list != null && list.size() > 0) {
//
//                System.out.println("Found restservice..");
//
//                String host = list.get(0).getHost();
//                int port = list.get(0).getPort();
//
//                System.out.println("Returning RestService host " + host + " and port " + port);
//
//            return "http://" + host + ":" + port;
//        }
//
//        System.out.println("Could not find any RestService");
//        return null;
//    }

    public String getUser(String user) {

//        ServiceInstance serviceInstance = loadBalancerClient.choose("restservice");
//        String uri = serviceInstance.getUri().toString();

        //String endpoint = "http://restservice:8080/service/sayHello/{user}";
        //String user = sampleEntity.get().getSurname();
//        String endpoint = serviceUrl();
//        String endpoint = uri + "/service/sayHello/{user}";
        String endpoint = "http://localhost:8080/service/sayHello/{user}";
        logger.info("Calling restTemplate");
        String response = restTemplate.getForObject(endpoint,String.class,user);
//        String response = restTemplate.exchange(endpoint, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
//        }, user).getBody();
        logger.info("Response: {}", response);
        return "Response Received as " + response + " -  " + new Date();
    }

}
