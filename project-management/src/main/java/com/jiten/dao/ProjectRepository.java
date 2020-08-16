package com.jiten.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jiten.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();
}