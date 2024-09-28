package com.entity;

public class Account {

	private int accno;
	private String name;
	private String emailid;
	private float amount;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Account(int accno, String name, String emailid, float amount) {
		super();
		this.accno = accno;
		this.name = name;
		this.emailid = emailid;
		this.amount = amount;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", name=" + name + ", emailid=" + emailid + ", amount=" + amount + "]";
	}
	
	
}
