package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public String isAdmin(String user, String p)
	{
		Boolean ret;
		if(user == null || user.equals("") || p == null || p.equals(""))
		{
			System.out.println("Exception occured");
			return null;
		}
		ret = userDao.isAdminLogin(user, p);
		if(ret == null)
			return "invalidLogin.jsp";
		if(ret)
		{
			return "adminLogin.jsp";
		}
		else
		{
			return "userLogin.jsp";
		}
	}
}
