package com.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Boolean isAdminLogin(String email, String passwd) {
		Boolean ret = null;
		try
		{
			List<Map<String, Object>> loList = jdbcTemplate.queryForList("Select * from Users where emailID = ? and passwd = ?", email, passwd);
			
			if(loList.isEmpty()) {
				return ret;
			}
			ret = Boolean.parseBoolean(loList.get(0).get("isAdmin").toString());
			
		}
		catch (Exception e)
		{
			ret = null;
			e.printStackTrace();
		}
		return ret;
	}
	
}
