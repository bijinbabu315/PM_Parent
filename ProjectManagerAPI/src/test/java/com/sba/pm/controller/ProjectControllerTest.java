package com.sba.pm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.impl.ProjectServiceImpl;

public class ProjectControllerTest {
	@InjectMocks
	ProjectController projectController;

	@Mock
	ProjectServiceImpl projectService;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
	}

	@Test
	public void createOrUpdate() throws Exception {
		Mockito.when(projectService.saveOrUpdateProject(createMockProject())).thenReturn(1);
		Assert.assertNotNull(projectController.createOrUpdate(createMockProject()));
	}

	@Test
	public void getAllProjects() throws Exception {
		List<ProjectEntity> projectList = new ArrayList<ProjectEntity>();
		projectList.add(createMockProject());
		Mockito.when(projectService.getAllProjects()).thenReturn(projectList);
		Assert.assertNotNull(projectController.getAllProjects());
	}

	@Test
	public void deleteProject() throws Exception {
		Mockito.when(projectService.delete((1))).thenReturn(1);
		Assert.assertNotNull(projectController.deleteProject("1"));
	}

	private ProjectEntity createMockProject() {
		ProjectEntity project = new ProjectEntity();
		project.setId(1);
		project.setProject("Test Project");
		project.setPriority(27);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		UserEntity user = new UserEntity();
		user.setId(1);
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setEmployeeId(new Long(1234));
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		project.setUser(userList);

		return project;
	}

}
