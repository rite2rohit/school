package com.kstech.model;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmployeeVO   implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    
   

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String name;
	private String fathername;
	private String mothername;
	private String addressid;
	private String sex;
	private Date dob;
	private String mobileNo;
	private String designation;
	private String jobType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Long getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(Long employee_Id) {
		this.employee_Id = employee_Id;
	}
	
	
	private Long employee_Id;
	
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    private String email;

}
