package com.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Department;
@Repository
public interface DepartmentRepository extends ReactiveCrudRepository<Department, Integer>{

}
