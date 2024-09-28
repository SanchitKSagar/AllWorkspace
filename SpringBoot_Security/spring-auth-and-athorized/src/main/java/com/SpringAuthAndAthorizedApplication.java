package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringAuthAndAthorizedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthAndAthorizedApplication.class, args);
		System.out.println("spring boot with authentication and authrorization up!");
	}

}
