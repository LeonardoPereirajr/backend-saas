package com.gh.backend.gh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gh.backend.gh")
public class GhApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhApplication.class, args);
	}

}	
