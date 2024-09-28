package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public String storeEmployee(Employee employee) {
		Optional<Employee> emp = dao.findById(employee.getEid());
		if(emp.isPresent())
			return "Employee Already Exists";
		else
		{
			dao.save(employee);
			return "Employee saved successfully";
		}
	}
	public List<Employee> findAllEmployees() {
		return dao.findAll();
	}
	
	public String deleteEmployeeById(int eid) {
		Optional<Employee> emp = dao.findById(eid);
		if(emp.isPresent())
		{
			Employee e = emp.get();
			dao.delete(e);
			return "Employee Deleted successfully";
		}
		else
		{
			return "Employee with ID: "+ eid + " Not found";
		}
	}
	public String updateEmployeeById(Employee emp) {
		Optional<Employee> empO = dao.findById(emp.getEid());
		if(empO.isPresent())
		{
			Employee e = empO.get();
			e.setEname(emp.getEname());
			e.setSalary(emp.getSalary());
			dao.saveAndFlush(e);
			return "Employee Updated successfully";
		}
		else
		{
			return "Employee with ID: "+ emp.getEid() + " Not found";
		}
	}
	public String findEmployee(int eid) {
		Optional<Employee> emp = dao.findById(eid);
		if(emp.isPresent())
		{
			return emp.get().toString();
		}
		else
		{
			return "Employee with ID: "+ eid + " Not found";
		}
	}
	
	public Employee findEmployeeById(int eid) {
		Optional<Employee> emp = dao.findById(eid);
		if(emp.isPresent())
		{
			return emp.get();
		}
		else
		{
			return null;
		}
	}
}
