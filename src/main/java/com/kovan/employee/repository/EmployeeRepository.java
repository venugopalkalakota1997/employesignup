package com.kovan.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kovan.employee.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee where username = :userName", nativeQuery = true)
	public Employee findByName(@Param(value = "userName") String userName);

}
