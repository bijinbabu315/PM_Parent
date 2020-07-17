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

import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.impl.UserServiceImpl;



@RunWith(SpringRunner.class)
public class UserControllerTest {
	
    @InjectMocks
    UserController userController;
    
    @Mock
    UserServiceImpl userService;
    
	MockMvc mockMvc;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void createOrUpdate() throws Exception {
		Mockito.when(userService.saveOrUpdateUser(createMockUser())).thenReturn(1);
		Assert.assertNotNull(userController.createOrUpdate(createMockUser())) ;		
	}
	
	@Test
	public void getAllUsers() throws Exception {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(createMockUser());
		Mockito.when(userService.getAllUsers()).thenReturn(userList);
		Assert.assertNotNull(userController.getAllUsers()) ;
	}
	
	@Test
	public void deleteUser() throws Exception {
		Mockito.when(userService.deleteUser(1)).thenReturn(1);
		Assert.assertNotNull(userController.deleteUser("1")) ;			
	}
	
	@Test
	public void updateProjectInUser() throws Exception {
		Mockito.when(userService.updateProjectInUser(createMockProject())).thenReturn(1);
		Assert.assertNotNull(userController.updateProjectInUser(createMockProject())) ;			
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
