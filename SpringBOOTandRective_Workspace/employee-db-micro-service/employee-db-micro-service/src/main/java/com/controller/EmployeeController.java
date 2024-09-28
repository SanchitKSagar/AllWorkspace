package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.model.Department;
import com.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("employees")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value = "finddepartment/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Department> findDepartment(@PathVariable("did") int did){
		return employeeService.findDepartmentInfo(did);
	}
	
	@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> storeEmployee(@RequestBody Employee employee){
		//return employeeService.storeEmployee(employee);
		return employeeService.storeEmployeeByPassingDeptId(employee);
	}
	
	@DeleteMapping(value = "delete/{eid}")
	public Mono<String> deleteEmployee(@PathVariable("eid") int eid){
		return employeeService.deleteEmployee(eid);
	}
	
	@PutMapping(value = "update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
	}
	
	@GetMapping(value = "findemployeebyid/{eid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Employee> findEmployeeById(@PathVariable("eid") int eid){
		return employeeService.findEmployeeById(eid);
	}
	
	@GetMapping(value = "findallemployee",produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Employee> findAll(){
		return employeeService.findAll();
	}
}
