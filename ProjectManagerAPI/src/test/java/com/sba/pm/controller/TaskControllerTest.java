package com.sba.pm.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.sba.pm.entity.TaskEntity;
import com.sba.pm.services.impl.TaskServiceImpl;


@RunWith(SpringRunner.class)
public class TaskControllerTest {
	@InjectMocks
	TaskController taskController;
    
    @Mock
    TaskServiceImpl taskService;
    
	MockMvc mockMvc;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
	}
	
	@Test
	public void createOrUpdate() throws Exception {
		Mockito.when(taskService.saveOrUpdateTask(createMockTask())).thenReturn(1);
		Assert.assertNotNull(taskController.createOrUpdate(createMockTask())) ;		
	}
	
	@Test
	public void getAllTasks() throws Exception {
		List<TaskEntity> taskList = new ArrayList<TaskEntity>();
		taskList.add(createMockTask());
		Mockito.when(taskService.getAllTasks()).thenReturn(taskList);
		Assert.assertNotNull(taskController.getAllTasks()) ;
	}

	private TaskEntity createMockTask() {
		TaskEntity task = new TaskEntity();
		task.setId(1);
		task.setTask("Project Task");
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		task.setStatus(0);
		task.setPriority(0);
				
		return task;
	}
}
