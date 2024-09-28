package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringApiGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGetwayApplication.class, args);
		System.err.println("api gateway running on port number 8080");
	}

	@Bean
	public RouteLocator myCustomerLocator(RouteLocatorBuilder builder) {
		System.out.println("I Came Here");
		
		return builder.
				routes().route(r->r.path("/account/**").and().method("GET","PUT","DELETE","POST").
						filters(f->f.addRequestParameter("msg", "Welcome")).uri("http://localhost:9090")).
				route(r->r.path("/gpay/**").and().method("GET","POST","PUT","DELETE").filters(f->f.addResponseHeader("res-key", "res-value")).
										uri("http://localhost:9191")).
				route(r->r.path("/feign/**").and().method("GET").uri("http://localhost:9292")).
				build();
	}
}
