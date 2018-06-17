package com.apptrics.employeedetails.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Employee")
public class EmployeePOJO {

	@Column(name="employeeName")
	private String employeeName;

	@Id
	@GeneratedValue
	@Column(name="employeeId")
	private int employeeId;
	
	@Column(name="employeeSalary")
	private int employeeSalary;
	
	@Column(name="employeeDept")
	private String employeeDept;
	
	@Transient
	private boolean temp;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeDept() {
		return employeeDept;
	}
	public void setEmployeeDept(String employeeDept) {
		this.employeeDept = employeeDept;
	}
	@Override
	public String toString() {
		return "EmployeePOJO [employeeName=" + employeeName + ", employeeId=" + employeeId + ", employeeSalary="
				+ employeeSalary + ", employeeDept=" + employeeDept + "]";
	}
	
}
