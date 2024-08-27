package com.example.demo.TestingRestController.controllers;

import com.example.demo.TestingRestController.services.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    public @ResponseBody String greeting() {
        return helloService.getWelcomeMessage();
    }
}
