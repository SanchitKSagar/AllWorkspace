package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Enrollment;
import com.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentRepository erepo;
	
	public List<Enrollment> getAll()
	{
		return erepo.findAll();
	}
	
	public String enroll(Enrollment e)
	{
		Optional<Enrollment > fe = erepo.findById(e.getEk());
		if(fe.isPresent())
			return "Course already enrolled";
		else
		{
			erepo.save(e);
			return "Course enrolled successfully";
		}
	}
}
