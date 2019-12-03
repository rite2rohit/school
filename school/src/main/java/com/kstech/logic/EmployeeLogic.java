package com.kstech.logic;

import org.springframework.stereotype.Service;

import com.kstech.model.EmployeeVO;

@Service
public interface EmployeeLogic {

	void addEmployee(EmployeeVO employee);


	EmployeeVO getEmployeeById(Long id);

}
