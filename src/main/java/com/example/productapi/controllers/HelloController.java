package com.example.productapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotation.

@RequestMapping("/api/hello") // URL endpoint.
public class HelloController {

    @GetMapping // Handle GET request.
    public String welcome() {
        return "Hello World on Spring Boot Rest API";
    }

}
