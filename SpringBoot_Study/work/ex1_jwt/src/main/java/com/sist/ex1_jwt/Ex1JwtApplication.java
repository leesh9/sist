package com.sist.ex1_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Ex1JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex1JwtApplication.class, args);
    }

}