package com.sba.pm.dao.impl;


import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
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
public class UserDaoImplTest {
	
    @InjectMocks
    UserDaoImpl userDao;
    
    @Mock
	private EntityManagerFactory entityManagerFactory;
    
    @Mock
    PlatformTransactionManager transactionManager;
    
    MockMvc mockMvc;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userDao).build();
	}
    
    @Test
    public void saveOrUpdateUser() {
    	
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	Transaction beginTransaction = Mockito.mock(Transaction.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Assert.assertNotNull(userDao.saveOrUpdateUser(createMockUser()));
    	
    }
    
    @Test
    public void getAllUsers() {
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
    	CriteriaQuery<UserEntity> createQuery = Mockito.mock(CriteriaQuery.class);
    	Root<UserEntity> root = Mockito.mock(Root.class);
    	Query<UserEntity> query = Mockito.mock(Query.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.getCriteriaBuilder()).thenReturn(cb);
    	Mockito.when(cb.createQuery(UserEntity.class)).thenReturn(createQuery);
    	Mockito.when(createQuery.from(UserEntity.class)).thenReturn(root);
    	Mockito.when(session.createQuery(createQuery)).thenReturn(query);
    	
    	Assert.assertNotNull(userDao.getAllUsers());
    }
    
    
    @Test
    public void deleteUser() {
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	Session session = Mockito.mock(Session.class);
    	Transaction beginTransaction = Mockito.mock(Transaction.class);
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	
    	Assert.assertNull(userDao.deleteUser(1));
    	
    }
    
    @Test
    public void updateProjectInUser() {
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
    	CriteriaUpdate<UserEntity> criteriaUpdate = Mockito.mock(CriteriaUpdate.class);
    	CriteriaQuery<UserEntity> createQuery = Mockito.mock(CriteriaQuery.class);
    	Root<UserEntity> root = Mockito.mock(Root.class);
    	Query<UserEntity> query = Mockito.mock(Query.class);
    	
    	Transaction beginTransaction = Mockito.mock(Transaction.class);
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Mockito.when(session.getCriteriaBuilder()).thenReturn(criteriaBuilder);
    	Mockito.when(criteriaBuilder.createCriteriaUpdate(UserEntity.class)).thenReturn(criteriaUpdate);
    	Mockito.when(criteriaBuilder.createQuery(UserEntity.class)).thenReturn(createQuery);
    	Mockito.when(criteriaUpdate.from(UserEntity.class)).thenReturn(root);
    	Mockito.when(createQuery.from(UserEntity.class)).thenReturn(root);
    	Mockito.when(session.createQuery(createQuery)).thenReturn(query);
    	Assert.assertNotNull(userDao.updateProjectInUser(createMockProject()));
    	
    }
    
	private UserEntity createMockUser() {
		UserEntity user = new UserEntity() ;
		user.setId(1);
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setEmployeeId(new Long(1234));
		
		return user;
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
