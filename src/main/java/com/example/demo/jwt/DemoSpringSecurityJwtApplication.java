package com.example.demo.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
public class DemoSpringSecurityJwtApplication {
	
	private static Logger log = LoggerFactory.getLogger(DemoSpringSecurityJwtApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringSecurityJwtApplication.class, args);
	}
	
}
