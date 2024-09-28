package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bean.Employee;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
public class EmployeController {

	@GetMapping(value="finEmployee", produces = MediaType.APPLICATION_JSON_VALUE 	)
	public Mono<Employee> getEmployee()
	{
		Employee emp = new Employee(1,"Ravi",40000);
		Mono<Employee> mono = Mono.just(emp);
		return mono;
	}

	
}
