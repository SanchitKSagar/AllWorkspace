package com.Bean;

import org.springframework.stereotype.Component;

@Component
public class Users {

	private String emailID;
	private String passwd;
	private boolean isAdmin;
	
	
	public Users(String emailID, String passwd, boolean isAdmin) {
		super();
		this.emailID = emailID;
		this.passwd = passwd;
		this.isAdmin = isAdmin;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Users [emailID=" + emailID + ", passwd=" + passwd + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
	
}
