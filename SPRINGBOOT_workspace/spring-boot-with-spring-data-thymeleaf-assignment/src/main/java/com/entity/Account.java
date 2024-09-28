package com.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Account {

	@Id
	private long accountNo;
	private String name;
	private float amount;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(long accountNo, String name, float amount) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.amount = amount;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", amount=" + amount + "]";
	}
	
	
	
}
