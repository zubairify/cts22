package com.cts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cts.docs.Employee;
import com.cts.service.EmployeeService;
import com.cts.util.InvalidEmployeeException;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	// http://localhost:8880/add
	@PostMapping(value = "/add", consumes = "application/json")
	public String addEmp(@RequestBody Employee emp) {
		int eno = service.save(emp);
		return "Employee saved with No:" + eno;
	}
	
	// http://localhost:8880/fetch/101
	@GetMapping(value = "/fetch/{empNo}", produces = "application/json")
	public Employee getEmp(@PathVariable int empNo) {
		try {
			Employee emp = service.fetch(empNo);
			return emp;
		} catch (InvalidEmployeeException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	// http://localhost:8880/list
	@GetMapping(value = "/list", produces = "application/json")
	public List<Employee> getList() {
		return service.list();
	}
	
	// http://localhost:8880/post?post=Clerk
	@GetMapping(value = "/post", produces = "application/json")
	public List<Employee> listByPost(@RequestParam String post) {
		return service.listByPost(post);
	}
	
	@GetMapping(value = "/earns/{amount}", produces = "application/json")
	public List<Employee> earnsAbove(@PathVariable double amount) {
		return service.earningAbove(amount);
	}
}
