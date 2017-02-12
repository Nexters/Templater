package com.templater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TemplaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplaterApplication.class, args);
		
	}
}
