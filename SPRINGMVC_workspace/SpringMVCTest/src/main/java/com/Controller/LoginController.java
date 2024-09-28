package com.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService us;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView handleLogin(HttpServletRequest hsr) {
		ModelAndView mv = new ModelAndView();
		String emailID = hsr.getParameter("emailID");
		String passwd = hsr.getParameter("passwd");
		mv.setViewName(us.isAdmin(emailID, passwd));
		return mv;
	}
}
