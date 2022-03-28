package com.cts.service;

import java.util.List;

import com.cts.docs.Employee;
import com.cts.util.InvalidEmployeeException;

public interface EmployeeService {

	int save(Employee e);
	
	Employee fetch(int empNo) throws InvalidEmployeeException;
	
	List<Employee> list();
	
	List<Employee> listByPost(String post);
	
	List<Employee> earningAbove(double amount);
}
