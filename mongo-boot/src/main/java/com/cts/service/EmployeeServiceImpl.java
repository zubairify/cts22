package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.docs.Employee;
import com.cts.repo.EmployeeRepository;
import com.cts.util.InvalidEmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public int save(Employee e) {
		repo.save(e);
		return e.getEmpNo();
	}

	@Override
	public Employee fetch(int empNo) throws InvalidEmployeeException {
		return repo.findById(empNo).orElseThrow(() -> new InvalidEmployeeException("Invalid Emp No:" + empNo));
	}

	@Override
	public List<Employee> list() {
		return repo.findAll();
	}

	@Override
	public List<Employee> listByPost(String post) {
		return repo.findByPost(post);
	}

	@Override
	public List<Employee> earningAbove(double amount) {
		return repo.earningAbove(amount);
	}
}
