package com.cts.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cts.docs.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

	List<Employee> findByPost(String post);
	
	@Query("{'salary':{$gt:?0}}")
	List<Employee> earningAbove(double amount);
}
