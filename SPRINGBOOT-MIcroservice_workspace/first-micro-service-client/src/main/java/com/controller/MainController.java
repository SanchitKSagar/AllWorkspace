package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sayHello()
	{
		System.out.println("Hello Main Controller up");
		return "Hello Main Controller up";
	}
}
