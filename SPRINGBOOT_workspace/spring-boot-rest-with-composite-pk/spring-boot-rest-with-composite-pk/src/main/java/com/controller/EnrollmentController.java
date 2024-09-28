package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Enrollment;
import com.service.EnrollmentService;

@RestController
public class EnrollmentController {

	@Autowired
	EnrollmentService es;
	
	@RequestMapping(value = "enrollment",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Enrollment> getAll() 
	{
		return es.getAll();
	}
	
	@RequestMapping(value = "enroll",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String store(@RequestBody Enrollment e)
	{
		System.out.println(e);
//		return "h";
		return es.enroll(e);
	}
	
}
