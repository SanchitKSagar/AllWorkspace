package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Department;
import com.service.DepartmentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("department")
@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Department> storeDepartment(@RequestBody Department department){
		return departmentService.storeDepartment(department);
	}
	
	@GetMapping(value = "findbyid/{did}")
	public Mono<Department> findDepartmentById(@PathVariable("did") int did){
		return departmentService.findDepartmentById(did);
	}
	
	@GetMapping(value = "find",produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Department> findAllDepartment() {
		return departmentService.findAllDepartment();
	}
}
