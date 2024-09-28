package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Account;
import com.service.FeignService;

@RestController
@RequestMapping("feign")
public class FeignController {

	@Autowired
	FeignService feignService;
	
	@GetMapping(value = "findbalanace/{accno}")
	public String findAccountBalance(@PathVariable("accno") int accno) {
		return feignService.findAccountDetails(accno);
	}
	
	@GetMapping(value = "findbalanacebyemailid/{emailid}")
	public String findAccountBalanceUsingEmailId(@PathVariable("emailid") String emailid) {
		return feignService.findBalance(emailid);
	}
	
	@PostMapping(value= "storeAccount")
	public String storeAccount(@RequestBody Account account){
		return feignService.createAccount(account);
	}
	
}
