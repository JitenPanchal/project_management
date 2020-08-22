package com.jiten.pma;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.jiten.dao.ProjectRepository;
import com.jiten.pma.ProjectManagementApplication;
import com.jiten.pma.entities.Project;

@SpringBootTest
//@ContextConfiguration(classes = ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
//@DataJpaTest
//@SqlGroup({
//		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:schema.sql",
//				"classpath:data.sql" }),
//		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = { "classpath:drop.sql" }) })
public class ProjectRepositoryIntegrationTest {
	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void if_new_project_saved_then_success() {
		Project project = new Project("Test Project", "Complete", "Test Project Description");

		projectRepository.save(project);

		assertEquals(1, projectRepository.findAll().size());
	}
}