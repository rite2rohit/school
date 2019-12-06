package com.kstech.logic.impl;

import java.util.Optional;
import java.util.function.Consumer;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kstech.dao.AddressDAO;
import com.kstech.dao.EmployeeDAO;
import com.kstech.logic.EmployeeLogic;
import com.kstech.model.Address;
import com.kstech.model.Employee;
import com.kstech.model.EmployeeVO;


@Service
public class EmployeeLogicImpl implements EmployeeLogic {
	
	@Autowired
	EmployeeDAO employeeDao;
	
	@Autowired
	AddressDAO addressDao;

	@Override
	public void addEmployee(EmployeeVO employee) {
		
		
		Employee employeeDTO= new Employee();
		BeanUtils.copyProperties(employee, employeeDTO);
		employeeDao.save(employeeDTO);
		
	}

	@Override
	public EmployeeVO getEmployeeById(Long id) {
		Employee employee=new Employee();
		employee.setEmployeeId(id);
		Optional<Employee> employeeRet =employeeDao.findById(id);
		EmployeeVO employeeVO= new EmployeeVO();
		BeanUtils.copyProperties(employeeRet, employeeVO);
		return employeeVO;
	}

	@Override
	public void addEmployeeAddress(Long id, Address address) {
		Optional<Employee> employeeRet =employeeDao.findById(id);
		address.getEmployees().add(employeeRet.get());
		addressDao.save(address);
	}
	
	
	

}
