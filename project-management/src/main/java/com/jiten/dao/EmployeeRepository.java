package com.jiten.dao;

import org.springframework.data.repository.CrudRepository;

import com.jiten.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}