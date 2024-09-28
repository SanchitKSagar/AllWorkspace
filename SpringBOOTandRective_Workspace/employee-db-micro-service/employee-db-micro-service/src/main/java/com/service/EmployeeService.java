package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bean.Employee;
import com.model.Department;
import com.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	@Autowired
	WebClient.Builder webClient;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public  Mono<Department>  findDepartmentInfo(int did) {			// This method give mono of department 
		return webClient.build().get().uri("http://DEPARTMENT-MICRO-SERVICE/department/findbyid/"+did).retrieve().
				bodyToMono(Department.class);
	}
	
	// employeeRepository.methodCall().flatMap(true).switchIfEmpty();
	public Mono<String> storeEmployee(Employee emp){
		emp.setNew(true);
		return employeeRepository.findById(emp.getEid()).
				flatMap(empObject-> {
						return Mono.just("Employee record already present");
				}).
				switchIfEmpty(employeeRepository.save(emp).thenReturn("Employee record saved"));
	}
	
	public Mono<String> storeEmployeeByPassingDeptId(Employee emp){	// eid, ename,salary,did not department 
	
		return findDepartmentInfo(emp.getDid()).flatMap(department-> {
			
			//return Mono.just("your department name is "+department.getDname());
			
			emp.setNew(true);
			emp.setDepartmentname(department.getDname());
			return employeeRepository.findById(emp.getEid()).
					flatMap(empObject-> {
							return Mono.just("Employee record already present");
					}).
					switchIfEmpty(employeeRepository.save(emp).thenReturn("Employee record saved"));
			
		}).switchIfEmpty(Mono.just("No department present, So Employee record didn't store "));
		
		
		
	}
	
	public Mono<String> deleteEmployee(int id){
		return employeeRepository.findById(id).
				flatMap(empObject-> {
						return employeeRepository.delete(empObject).then(Mono.just("Record deleted"));
				}).
				switchIfEmpty(Mono.just("Record is not present"));
	}
	
	public Mono<String> updateEmployee(Employee emp){
		emp.setNew(true);
		return employeeRepository.findById(emp.getEid()).
				flatMap(empObject-> {
						empObject.setSalary(emp.getSalary());
						
						return employeeRepository.save(empObject).then(Mono.just("Employee record updated"));
				}).
				switchIfEmpty(Mono.just("Record not present"));
	}
	
	public Mono<Employee> findEmployeeById(int eid){
		return employeeRepository.findById(eid);
	}
	
	public Flux<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
}
