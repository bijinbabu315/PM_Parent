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

import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;


@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	
    @InjectMocks
    UserServiceImpl userServiceImpl;
    
    @Mock
    UserDaoImpl userDaoImpl;
    
   
	@Test
	public void saveOrUpdateUser() throws Exception {
		Mockito.when(userDaoImpl.saveOrUpdateUser(createMockUser())).thenReturn(1);
		Assert.assertNotNull(userServiceImpl.saveOrUpdateUser(createMockUser())) ;		
	}
    
	@Test
	public void getAllUsers() throws Exception {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		UserEntity user = new UserEntity() ;
		userList.add(createMockUser());
		Mockito.when(userDaoImpl.getAllUsers()).thenReturn(userList);
		Assert.assertNotNull(userServiceImpl.getAllUsers()) ;
	}
	
	@Test
	public void updateProjectInUser() throws Exception {
		Mockito.when(userDaoImpl.updateProjectInUser(createMockProject())).thenReturn(1);
		Assert.assertNotNull(userServiceImpl.updateProjectInUser(createMockProject())) ;			
	}
	
	@Test
	public void deleteUser() throws Exception {
		Mockito.when(userDaoImpl.deleteUser((1))).thenReturn(1);
		Assert.assertNotNull(userServiceImpl.deleteUser(1)) ;			
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
	
	

