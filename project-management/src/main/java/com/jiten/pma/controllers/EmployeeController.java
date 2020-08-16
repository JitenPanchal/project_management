package com.jiten.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiten.dao.EmployeeRepository;
import com.jiten.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping
	public String displayEmployees(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		employeeRepository.save(employee);
		return "redirect:/employees/new";
	}
}