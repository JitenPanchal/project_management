package com.jiten.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jiten.pma.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	List<Employee> findAll();
}