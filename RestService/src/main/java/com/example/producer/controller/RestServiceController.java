package com.example.producer.controller;

import io.micrometer.common.util.internal.logging.InternalLogger;
import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class RestServiceController {

    private InternalLogger logger = Slf4JLoggerFactory.getInstance(RestServiceController.class);

    @Value("#{environment.POD_IP}")
    private String POD_IP;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name){
        logger.info("Hello from " + (POD_IP == null ? "Not a POD" : POD_IP) + " - " + name);
        return "Hello from " + (POD_IP == null ? "Not a POD" : POD_IP) + " - " + name;
    }

}
