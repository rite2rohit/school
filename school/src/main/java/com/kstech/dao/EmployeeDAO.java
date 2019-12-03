package com.kstech.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.kstech.model.Employee;

@Component
public interface EmployeeDAO extends CrudRepository<Employee, Long>{
	
	//public List<Employee> getAllEmployees() ;
    
     
   // public void addEmployee(Employee employee) ;
    
    //public Employee getEmployeeById(Employee employee) ;

}
