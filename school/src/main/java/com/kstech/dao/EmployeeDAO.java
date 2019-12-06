package com.kstech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.kstech.model.Employee;

@Component
public interface EmployeeDAO extends JpaRepository<Employee, Long>{
	
	
}
