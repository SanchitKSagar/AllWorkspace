package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.entity.Account;

@FeignClient(name = "ACCOUNT-MICRO-SERVICE")		// providing account micro service name part of eureka server 
public interface AccountFeignService {

	@GetMapping(value = "account/findbalance/{accno}")
	public String findBalance(@PathVariable("accno") int accno);	// this method call end point 
	
	@PostMapping(value = "account/create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Account account);
}
