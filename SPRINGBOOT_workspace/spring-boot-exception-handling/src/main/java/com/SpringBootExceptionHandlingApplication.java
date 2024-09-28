package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExceptionHandlingApplication.class, args);
		System.out.println("spring boot up!");
	}

}
