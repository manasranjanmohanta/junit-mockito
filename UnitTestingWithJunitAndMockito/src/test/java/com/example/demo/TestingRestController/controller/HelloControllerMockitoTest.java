package com.example.demo.TestingRestController.controller;

import com.example.demo.TestingRestController.controllers.HelloController;
import com.example.demo.TestingRestController.services.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Does not start the Spring Boot server or context.
// It is used for unit testing with mocked dependencies.
@ExtendWith(MockitoExtension.class)
public class HelloControllerMockitoTest {

    @Mock
    private HelloService helloService;

    @InjectMocks
    private HelloController helloController;

    @Test
    public void shouldReturnDefaultMessage() {
        // Mock the behavior of the service
        when(helloService.getWelcomeMessage()).thenReturn("Hello, World!");

        // Call the controller method
        String actualResponse = helloController.greeting();

        // Assert the response
        assertEquals("Hello, World!", actualResponse);
    }
}
