package com.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee implements Persistable<Integer>{
@Id
private int eid;
private String ename;
private String salary;
private String departmentname;
@Transient
private boolean isNew;					// this property ignore in db. 
@Transient
private int did;

public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public void setNew(boolean isNew) {
	this.isNew = isNew;
}
@Override
public Integer getId() {
	// TODO Auto-generated method stub
	return eid;
}
@Override
public boolean isNew() {					// it give confirmation is record is new or old. 
	// TODO Auto-generated method stub
	return isNew;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getDepartmentname() {
	return departmentname;
}
public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}

}
