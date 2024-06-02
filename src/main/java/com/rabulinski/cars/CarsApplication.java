package com.rabulinski.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@EnableFeignClients
@EnableMethodSecurity
@SpringBootApplication
@EnableConfigurationProperties
public class CarsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarsApplication.class, args);
    }
}
