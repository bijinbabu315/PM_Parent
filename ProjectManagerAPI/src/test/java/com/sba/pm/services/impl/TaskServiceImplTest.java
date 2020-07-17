package com.sba.pm.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.sba.pm.dao.impl.TaskDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.TaskEntity;
import com.sba.pm.entity.UserEntity;


@RunWith(SpringRunner.class)
public class TaskServiceImplTest {
	@InjectMocks
    TaskServiceImpl taskServiceImpl;
    
    @Mock
    TaskDaoImpl taskDaoImpl;
   
	@Test
	public void saveOrUpdateTask() throws Exception {
		Mockito.when(taskDaoImpl.saveOrUpdateTask(createMockTask())).thenReturn(1);
		Assert.assertNotNull(taskServiceImpl.saveOrUpdateTask(createMockTask())) ;		
	}
    
	@Test
	public void getAllTasks() throws Exception {
		List<TaskEntity> taskList = new ArrayList<TaskEntity>();
		taskList.add(createMockTask());
		Mockito.when(taskDaoImpl.getAllTasks()).thenReturn(taskList);
		Assert.assertNotNull(taskServiceImpl.getAllTasks()) ;
	}

	private TaskEntity createMockTask() {
		TaskEntity task = new TaskEntity();
		task.setId(1);
		task.setTask("Project Task");
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		task.setStatus(0);
		task.setPriority(0);
		task.setProjectEntity(createMockProject());
		task.setUserData(createMockUser());	
		return task;
	}
	
	private ProjectEntity createMockProject() {
		ProjectEntity project = new ProjectEntity();
		project.setId(1);
		project.setProject("Test Project");
		project.setPriority(27);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		return project;
	}
	
	private UserEntity createMockUser() {
		UserEntity user = new UserEntity() ;
		user.setId(1);
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setEmployeeId(new Long(1234));	
		
		return user;
	}

}