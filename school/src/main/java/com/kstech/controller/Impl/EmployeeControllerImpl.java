package com.kstech.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kstech.logic.EmployeeLogic;
import com.kstech.model.Address;
import com.kstech.model.EmployeeVO;
import com.kstech.model.Project;
import com.kstech.model.SuccessResponse;

@RestController
public class EmployeeControllerImpl {

	@Autowired
	private EmployeeLogic employeeLogic;

	@RequestMapping(value = "/employees/check", method = RequestMethod.GET)
	public String check() {

		return "Success";
	}

	@RequestMapping(value = "/employees/add", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeVO> addEmployee(@RequestBody EmployeeVO employee) {

		employeeLogic.addEmployee(employee);
		return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") Long id) {
		EmployeeVO employee = employeeLogic.getEmployeeById(id);

		return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeVO>> getEmployeeByName(@RequestParam("name") String name) {
		List<EmployeeVO> employees = employeeLogic.getEmployeeByName(name);
		return new ResponseEntity<List<EmployeeVO>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/address/{id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> addEmployeeAddress(@RequestBody Address address,
			@PathVariable("id") Long id) {
		employeeLogic.addEmployeeAddress(id, address);
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setMessage("Address Added Sucessfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/project/{id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> addEmployeeProject(@RequestBody Project project,
			@PathVariable("id") Long id) {
		employeeLogic.addEmployeeProject(id, project);
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setMessage("Project Added Sucessfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}

}
