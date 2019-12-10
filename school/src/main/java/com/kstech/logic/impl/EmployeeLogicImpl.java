package com.kstech.logic.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kstech.dao.EmployeeDAO;
import com.kstech.logic.EmployeeLogic;
import com.kstech.model.Address;
import com.kstech.model.Employee;
import com.kstech.model.EmployeeVO;
import com.kstech.model.Project;

@Service
public class EmployeeLogicImpl implements EmployeeLogic {

	@Autowired
	EmployeeDAO employeeDao;

	@Override
	public void addEmployee(EmployeeVO employee) {

		Employee employeeDTO = new Employee();
		BeanUtils.copyProperties(employee, employeeDTO);
		employeeDao.save(employeeDTO);

	}

	@Override
	public EmployeeVO getEmployeeById(Long id) {
		Employee employee = employeeDao.findById(id).get();
		EmployeeVO employeeVO = new EmployeeVO();
		BeanUtils.copyProperties(employee, employeeVO);
		return employeeVO;
	}

	@Override
	public void addEmployeeAddress(Long id, Address address) {
		Optional<Employee> employeeRet = employeeDao.findById(id);
		employeeRet.get().getAddress().add(address);
		employeeDao.save(employeeRet.get());

	}

	@Override
	public void addEmployeeProject(Long id, Project project) {
		Employee employee = employeeDao.findById(id).get();
		employee.getProjects().add(project);
		employeeDao.save(employee);

	}

}
