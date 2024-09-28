package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sayHello()
	{
		return "2nd Controller Up and running on 8081";
	}
}
