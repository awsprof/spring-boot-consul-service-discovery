package com.example.consumer.controller;

import com.example.consumer.service.ConsumingService;
import io.micrometer.common.util.internal.logging.InternalLogger;
import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SampleController {

//    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
    private InternalLogger logger = Slf4JLoggerFactory.getInstance(SampleController.class);

    @Autowired
    private ConsumingService consumingService;

    @GetMapping("/invoke/{user}")
    public String invokeUser(@PathVariable String user) {
        logger.info("Incoming user is: {}",user);
        return consumingService.getUser(user);
    }
}
