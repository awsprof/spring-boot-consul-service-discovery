package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class RestServiceController {

    @Value("#{environment.POD_IP}")
    private String POD_IP;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello from " + (POD_IP == null ? "Not a POD" : POD_IP) + " - " + name;
    }

}
