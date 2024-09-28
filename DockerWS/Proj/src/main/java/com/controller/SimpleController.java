package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	@GetMapping(value = "")
	public String hello() {
		return "Spring controller with Docker";
	}
}
