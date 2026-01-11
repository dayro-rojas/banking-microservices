package com.banking.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Esto obliga a Spring a buscar en TODO el proyecto, incluyendo la carpeta security
@ComponentScan(basePackages = "com.banking.auth_service")
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}