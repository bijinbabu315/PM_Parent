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
import com.sba.pm.entity.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectDaoImplTest {
	@InjectMocks
    ProjectDaoImpl projectDao;
    
    @Mock
	private EntityManagerFactory entityManagerFactory;
    
    @Mock
    PlatformTransactionManager transactionManager;
    
    MockMvc mockMvc;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(projectDao).build();
	}
    
    @Test
    public void saveOrUpdateProject() {
    	
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	Transaction beginTransaction = Mockito.mock(Transaction.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Assert.assertNotNull(projectDao.saveOrUpdateProject(createMockProject()));
    	
    }
    
    @Test
    public void getAllProjects() {
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
    	CriteriaQuery<ProjectEntity> createQuery = Mockito.mock(CriteriaQuery.class);
    	Root<ProjectEntity> root = Mockito.mock(Root.class);
    	Query<ProjectEntity> query = Mockito.mock(Query.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.getCriteriaBuilder()).thenReturn(cb);
    	Mockito.when(cb.createQuery(ProjectEntity.class)).thenReturn(createQuery);
    	Mockito.when(createQuery.from(ProjectEntity.class)).thenReturn(root);
    	Mockito.when(session.createQuery(createQuery)).thenReturn(query);
    	
    	Assert.assertNotNull(projectDao.getAllProjects());
    }
    
    @Test
    public void delete() {
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	Session session = Mockito.mock(Session.class);
    	Transaction beginTransaction = Mockito.mock(Transaction.class);
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Mockito.when(session.get(ProjectEntity.class, 1)).thenReturn(createMockProject());
    	
    	Assert.assertNull(projectDao.delete(1));
    	
    }
    
	private ProjectEntity createMockProject() {
		ProjectEntity project = new ProjectEntity();
		project.setId(1);
		project.setProject("Test Project");
		project.setPriority(27);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		UserEntity user = new UserEntity() ;
		user.setId(1);
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setEmployeeId(new Long(12589));
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		project.setUser(userList);
		
		return project;
	}

}
