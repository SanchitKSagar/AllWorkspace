package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repo")
public class SpringBootWithSpringDataThymeleafAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithSpringDataThymeleafAssignmentApplication.class, args);
		System.out.println("Spring BOOT application up and running ");
		System.out.println("Visit http://localhost:8080/ ");
	}

}
