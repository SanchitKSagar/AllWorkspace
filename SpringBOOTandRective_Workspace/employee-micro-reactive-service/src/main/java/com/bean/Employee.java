package com.bean;

public class Employee {
private int empid;
private String empname;
private float salary;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int empid, String empname, float salary) {
	super();
	this.empid = empid;
	this.empname = empname;
	this.salary = salary;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}

}
