package com.sba.pm.dao.impl;

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

import com.sba.pm.entity.ParentTaskEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskDaoImplTest {
	@InjectMocks
	ParentTaskDaoImpl parentTaskDao;
    
    @Mock
	private EntityManagerFactory entityManagerFactory;
    
    @Mock
    PlatformTransactionManager transactionManager;
    
    MockMvc mockMvc;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(parentTaskDao).build();
	}
    
    @Test
    public void saveUpadteParentTask() {
    	
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	Transaction beginTransaction = Mockito.mock(Transaction.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Assert.assertNotNull(parentTaskDao.saveOrUpadte(createMockParentTask()));
    	
    }
    
    @Test
    public void getAllParentTasks() {
    	Session session = Mockito.mock(Session.class);
    	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    	CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
    	CriteriaQuery<ParentTaskEntity> createQuery = Mockito.mock(CriteriaQuery.class);
    	Root<ParentTaskEntity> root = Mockito.mock(Root.class);
    	Query<ParentTaskEntity> query = Mockito.mock(Query.class);
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.getCriteriaBuilder()).thenReturn(cb);
    	Mockito.when(cb.createQuery(ParentTaskEntity.class)).thenReturn(createQuery);
    	Mockito.when(createQuery.from(ParentTaskEntity.class)).thenReturn(root);
    	Mockito.when(session.createQuery(createQuery)).thenReturn(query);
    	
    	Assert.assertNotNull(parentTaskDao.getAllParentTask());
    }
    
	private ParentTaskEntity createMockParentTask () {
		ParentTaskEntity parentTask = new ParentTaskEntity();
		parentTask.setId(1);
		parentTask.setParentTask("Test ParentTask");
				
		return parentTask;
	}
}
