package com.kstech.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kstech.logic.EmployeeLogic;
import com.kstech.model.Address;
import com.kstech.model.EmployeeVO;


@RestController
public class EmployeeControllerImpl  {
	
	   @Autowired
	   private EmployeeLogic employeeLogic;
	   
	   @RequestMapping(value = "/employees/check",method=RequestMethod.GET)
	   @ResponseBody
	   public String check()
{
		   
	       return "Success";
	   }
	
	   @RequestMapping(value = "/employees/add",method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE}, consumes=MediaType.APPLICATION_JSON_VALUE)
	   @ResponseBody
	   public ResponseEntity<EmployeeVO> addEmployee (@RequestBody EmployeeVO employee)
	   {
		   
		   employeeLogic.addEmployee(employee);
	       return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	   }
	    
	   @RequestMapping(value = "/employees/{id}",method=RequestMethod.GET) 
	   @ResponseBody
	   public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") Long id)
	   {
	       EmployeeVO employee = employeeLogic.getEmployeeById(id);
	        
	       return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/employees/address/{id}",method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE}, consumes=MediaType.APPLICATION_JSON_VALUE)
	   @ResponseBody
	   public ResponseEntity<Address> addEmployeeAddress (@RequestBody Address address,@PathVariable("id") Long id)
	   {
		   employeeLogic.addEmployeeAddress(id,address);
	       return new ResponseEntity<Address>(address, HttpStatus.OK);
	   }
	   
	   
	

}
