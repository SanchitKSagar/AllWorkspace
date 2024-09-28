package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient
public class EmployeeDbMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDbMicroServiceApplication.class, args);
		System.out.println("micro reactive micro service up");
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();	// using builder design pattern get the object. 
	}
}
