package com.kstech.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "employee")
public class Employee {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long employeeId;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@NotEmpty(message = "name must not be empty")
	private String name;
	private String fathername;
	private String mothername;
	private String sex;
	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be a valid email")
	private String email;
	private Date dob;
	@NotEmpty(message = "mobile No. must not be empty")
	private String mobileNo;
	private String designation;
	// @Column(name = "jobType")
	private String jobType;

	@OneToMany(mappedBy="employee")
	private Set<Address> address;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Employee_Project", joinColumns = { @JoinColumn(name = "employee_id") }, inverseJoinColumns = {
			@JoinColumn(name = "project_id") })
	Set<Project> projects = new HashSet<>();

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Employee() {

	}

	public Employee(Long employeeId, @NotEmpty(message = "name must not be empty") String name, String fathername,
			String mothername, String sex,
			@NotEmpty(message = "email must not be empty") @Email(message = "email should be a valid email") String email,
			Date dob, @NotEmpty(message = "mobile No. must not be empty") String mobileNo, String designation,
			String jobType, Set<Address> address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.fathername = fathername;
		this.mothername = mothername;
		this.sex = sex;
		this.email = email;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.designation = designation;
		this.jobType = jobType;
		this.address = address;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

}
