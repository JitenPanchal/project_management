package com.jiten.pma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jiten.dao.EmployeeRepository;

@Service
public class EmployeeService {
	
	EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository,
		@Qualifier("staffRepository1") IStaffRepository staffRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.staffRepository = staffRepository;
	}
	
	IStaffRepository staffRepository; 
	
//	EmployeeRepository employeeRepository;
//
//	@Autowired
//	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}
	
//	@Autowired
//	EmployeeRepository employeeRepository;
}
