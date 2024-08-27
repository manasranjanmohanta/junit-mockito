package com.example.demo.TestingRestController.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getWelcomeMessage() {
        return "Hello, World!";
    }
}
