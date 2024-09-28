package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView hello() {
		System.out.println("Hello message called.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		return mv;
	}
	@RequestMapping(value = "/display2", method = RequestMethod.GET)
	public ModelAndView hi() {
		System.out.println("Hi message called.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display2.jsp");
		return mv;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET )
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
}
