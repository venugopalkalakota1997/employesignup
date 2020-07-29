package com.kovan.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kovan.employee.ResponseTransfer;
import com.kovan.employee.execption.UserAlreadyExistsException;
import com.kovan.employee.model.Employee;
import com.kovan.employee.model.Work;
import com.kovan.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public ResponseTransfer createUser(Employee employee) throws UserAlreadyExistsException {
		Employee employee1 = employeeRepository.findByName(employee.getUserName());
		if (employee1 != null) {
			throw new UserAlreadyExistsException();
		} else {
			System.err.println(employee);
			for (Work q : employee.getWorkList()) {
				q.setEmployee(employee);
			}
			employeeRepository.save(employee);
			return new ResponseTransfer("User Added successfully");
		}
	}

	public List<Employee> getEmployees() {
		
		return employeeRepository.findAll();
	}

	public ResponseTransfer deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return new ResponseTransfer("deleted successfully");
	}
}
