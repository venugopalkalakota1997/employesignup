package com.kovan.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kovan.employee.ResponseTransfer;
import com.kovan.employee.execption.UserAlreadyExistsException;
import com.kovan.employee.model.Employee;
import com.kovan.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseTransfer createUser(@RequestBody Employee employee) throws UserAlreadyExistsException {
		System.err.println(employee);
		return employeeService.createUser(employee);
	}
	@GetMapping("/all")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseTransfer deleteEmployee(@PathVariable int id){
		return employeeService.deleteEmployee(id);
	}
}
