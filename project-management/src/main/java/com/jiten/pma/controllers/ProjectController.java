package com.jiten.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiten.dao.EmployeeRepository;
import com.jiten.dao.ProjectRepository;
import com.jiten.dto.ChartData;
import com.jiten.pma.entities.Employee;
import com.jiten.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		model.addAttribute("project", aProject);

		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("allEmployees", employees);

		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		projectRepository.save(project);

		return "redirect:/projects/new";
	}

//	@GetMapping("/timelines")
//	public String displayProjectTimelines(Model model) throws JsonProcessingException {
//
//		List<ChartData> timelineData = projectRepository.getTimeData();
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		String jsonTimelineString = objectMapper.writeValueAsString(timelineData);
//
//		System.out.println("---------- project timelines ----------");
//		System.out.println(jsonTimelineString);
//
//		model.addAttribute("projectTimeList", jsonTimelineString);
//
//		return "projects/project-timelines";
//	}
}