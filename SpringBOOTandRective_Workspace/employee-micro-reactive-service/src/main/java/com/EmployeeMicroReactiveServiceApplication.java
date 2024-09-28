package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient
public class EmployeeMicroReactiveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroReactiveServiceApplication.class, args);
		System.out.println("employee reactive micro service up on port number 9090");
	}

}
