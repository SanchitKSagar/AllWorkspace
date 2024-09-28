package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;

@Service
public class FeignService {

	@Autowired
	AccountFeignService accountFiegnService;
	
	@Autowired
	GpayFeignService gpayFeignService;
	
	public String findAccountDetails(int acno) {
		return accountFiegnService.findBalance(acno);
	}
	
	public String findBalance(String emailid) {
		return gpayFeignService.findBalace(emailid);
	}
	
	public String createAccount(Account acc){
		return accountFiegnService.createAccount(acc) ;
	}
}
