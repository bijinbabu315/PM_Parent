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

import com.sba.pm.dao.impl.ProjectDaoImpl;
import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;


@RunWith(SpringRunner.class)
public class ProjectServiceImplTest {
	@InjectMocks
    ProjectServiceImpl projectServiceImpl;
    
    @Mock
    ProjectDaoImpl projectDaoImpl;
    @Mock
    UserDaoImpl userDaoImpl;
    
   
	@Test
	public void saveOrUpdateProject() throws Exception {
		Mockito.when(projectDaoImpl.saveOrUpdateProject(createMockProject())).thenReturn(1);
		Assert.assertNotNull(projectServiceImpl.saveOrUpdateProject(createMockProject())) ;		
	}
    
	@Test
	public void getAllProjects() throws Exception {
		List<ProjectEntity> projectList = new ArrayList<ProjectEntity>();
		projectList.add(createMockProject());
		Mockito.when(projectDaoImpl.getAllProjects()).thenReturn(projectList);
		Assert.assertNotNull(projectServiceImpl.getAllProjects()) ;
	}
	
	@Test
	public void delete() throws Exception {
		Mockito.when(projectDaoImpl.delete((1))).thenReturn(1);
		Assert.assertNotNull(projectServiceImpl.delete(1)) ;			
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
		user.setFirstName("John");
		user.setLastName("Harry");
		user.setEmployeeId(new Long(1234));
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		project.setUser(userList);

		return project;
	}

}
