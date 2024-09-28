package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@GetMapping(value = "findemployee",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Employee> getEmployee() {
		Employee emp = new Employee(100, "Ravi", 24000);
		Mono<Employee> mm = Mono.just(emp);
		return mm;
	}
	@GetMapping(value = "findallemployees",produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Employee> getAllEmployees() {
		List<Employee> listOfEmp = Arrays.asList(new Employee(100, "Ravi", 34000),new Employee(101, "Raj", 36000),new Employee(102, "Ajay", 39000));
		Flux<Employee> ff = Flux.fromIterable(listOfEmp);
		return ff;
	}
}
