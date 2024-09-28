package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Department;
import com.repository.DepartmentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	

	
	public  Mono<Department> storeDepartment(Department department) {

	return departmentRepository.findById(department.getDid()).switchIfEmpty(departmentRepository.save(department));
	}
	
	public Mono<Department> findDepartmentById(int did){
		return departmentRepository.findById(did);
	}
	
	public Flux<Department> findAllDepartment() {
		return departmentRepository.findAll();
	}
}



