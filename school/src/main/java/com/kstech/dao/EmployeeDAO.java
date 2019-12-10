package com.kstech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.kstech.model.Employee;

@Component
public interface EmployeeDAO extends JpaRepository<Employee, Long>{
	
	List<Employee> getEmployeeByName(String name);
}
