package com.sist.ex0725_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Ex0725DbApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(
		SpringApplicationBuilder builder ){
			return builder.sources(Ex0725DbApplication.class);
		}

	public static void main(String[] args) {
		SpringApplication.run(Ex0725DbApplication.class, args);
	}

}
