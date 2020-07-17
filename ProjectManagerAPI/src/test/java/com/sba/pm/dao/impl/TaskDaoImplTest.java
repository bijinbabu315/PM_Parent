package com.sba.pm.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.PlatformTransactionManager;

import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.TaskEntity;
import com.sba.pm.entity.UserEntity;


@RunWith(SpringJUnit4ClassRunner.class)
public class TaskDaoImplTest {
	@InjectMocks
    TaskDaoImpl taskDao;
    
    @Mock
	private EntityManagerFactory entityManagerFactory;
    
    @Mock
    PlatformTransactionManager transactionManager;
    
    private MockMvc mockMvc;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(taskDao).build();
	}
    
    @Test
    public void saveOrUpdateTask() {
    	
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	Transaction beginTransaction = Mockito.mock(Transaction.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Assert.assertNotNull(taskDao.saveOrUpdateTask(createMockTask()));
    	
    }
    
    @Test
    public void testgetAllTasks() {
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
    	CriteriaQuery<TaskEntity> createQuery = Mockito.mock(CriteriaQuery.class);
    	Root<TaskEntity> root = Mockito.mock(Root.class);
    	Query<TaskEntity> query = Mockito.mock(Query.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.getCriteriaBuilder()).thenReturn(cb);
    	Mockito.when(cb.createQuery(TaskEntity.class)).thenReturn(createQuery);
    	Mockito.when(createQuery.from(TaskEntity.class)).thenReturn(root);
    	Mockito.when(session.createQuery(createQuery)).thenReturn(query);
    	
    	Assert.assertNotNull(taskDao.getAllTasks());
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