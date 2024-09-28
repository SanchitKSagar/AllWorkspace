package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "checkuserwithget", method = RequestMethod.GET)
	public ModelAndView getMethod(HttpServletRequest hr) {
		String email = hr.getParameter("emailid");
		String pass = hr.getParameter("password");
		ModelAndView mv = new ModelAndView();
		if(email.equals("abc@gmail.com") && pass.equals("123") )
		{
			mv.setViewName("success.jsp");
		}
		else
		{
			mv.setViewName("failure.jsp");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "checkuserwithpost", method = RequestMethod.POST)
	public ModelAndView postMethod(HttpServletRequest hr) {
		
		String email = hr.getParameter("emailid");
		String pass = hr.getParameter("password");
		ModelAndView mv = new ModelAndView();
		if(email.equals("abc@gmail.com") && pass.equals("123") )
		{
			mv.setViewName("success.jsp");
		}
		else
		{
			mv.setViewName("failure.jsp");
		}
		return mv;
	}
}
