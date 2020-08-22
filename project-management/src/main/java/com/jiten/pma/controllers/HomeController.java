package com.jiten.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiten.dao.EmployeeRepository;
import com.jiten.dao.ProjectRepository;
import com.jiten.dto.ChartData;
import com.jiten.dto.EmployeeProject;
import com.jiten.pma.entities.Employee;
import com.jiten.pma.entities.Project;
import com.jiten.pma.springExample.Car;

@Controller
public class HomeController {
	
	@Value("${version}")
	String versionNumber;
	
	@Autowired
	Car car;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", versionNumber);
		
		// we are querying the database for projects
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = projectRepository.getProjectStatus();
		
		// Lets convert projectData object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		// we are querying the database for employees
		List<EmployeeProject> employeesProjectCnt = employeeRepository.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		
		
		return "main/home";
		
	}
}
