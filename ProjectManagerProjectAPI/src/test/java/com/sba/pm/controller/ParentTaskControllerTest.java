package com.sba.pm.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sba.pm.entity.ParentTaskEntity;
import com.sba.pm.services.impl.ParentTaskServiceImpl;

@RunWith(SpringRunner.class)
public class ParentTaskControllerTest {
	@InjectMocks
	ParentTaskController parentTaskController;

	@Mock
	ParentTaskServiceImpl parentTaskService;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(parentTaskController).build();
	}

	@Test
	public void getAllParentTasks() throws Exception {
		Mockito.when(parentTaskService.getAllParentTask()).thenReturn(createMockParentTaskList());
		Assert.assertNotNull(parentTaskController.getAllParentTask());
	}

	@Test
	public void saveOrUpadte() throws Exception {
		ParentTaskEntity parentTaskEntity = new ParentTaskEntity();
		parentTaskEntity.setId(1);
		parentTaskEntity.setParentTask("Test Project");
		Mockito.when(parentTaskService.saveOrUpadte(parentTaskEntity)).thenReturn(1);
		Assert.assertNotNull(parentTaskController.createOrUpdate(parentTaskEntity));
	}

	private List<ParentTaskEntity> createMockParentTaskList() {
		List<ParentTaskEntity> parentTaskList = new ArrayList<ParentTaskEntity>();
		ParentTaskEntity parentTaskEntity = new ParentTaskEntity();
		parentTaskEntity.setId(1);
		parentTaskEntity.setParentTask("Test Project");
		parentTaskList.add(parentTaskEntity);
		return parentTaskList;
	}
}
