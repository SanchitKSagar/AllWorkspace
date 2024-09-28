package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("public")
@RestController
public class NormalController {

	@GetMapping(value = "")
	public String greeting() {
		return "Welcome to Web Page public access";
	}
}
