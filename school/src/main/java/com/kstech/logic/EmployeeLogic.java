package com.kstech.logic;

import org.springframework.stereotype.Service;

import com.kstech.model.Address;
import com.kstech.model.EmployeeVO;
import com.kstech.model.Project;

@Service
public interface EmployeeLogic {

	void addEmployee(EmployeeVO employee);


	EmployeeVO getEmployeeById(Long id);


	void addEmployeeAddress(Long id, Address address);


	void addEmployeeProject(Long id, Project project);

}
