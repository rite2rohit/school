package com.kstech.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kstech.app.exception.RecordNotFoundException;
import com.kstech.app.exception.SchoolBusinessException;
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
		Optional<Employee> employeeOpt = employeeDao.findById(id);
		Employee employee = null;
		try{
			 employee=	employeeOpt.get();
		}catch (NoSuchElementException e) {
			throw new SchoolBusinessException("emp.not.found",new String[] {id.toString()}) ;
		}
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

	@Override
	public List<EmployeeVO> getEmployeeByName(String name) {
		List<Employee> employees = employeeDao.getEmployeeByName(name);
		if(employees.size()==0) {
			throw new  RecordNotFoundException("No Employee found with name:- "+name);
		}
		List<EmployeeVO> employeeVO = new ArrayList<>();
		for(Employee emp:employees) {
			EmployeeVO	employee=new EmployeeVO();
			BeanUtils.copyProperties(emp, employee);
			employeeVO.add(employee);
		}
		
		return employeeVO;
	}

}
