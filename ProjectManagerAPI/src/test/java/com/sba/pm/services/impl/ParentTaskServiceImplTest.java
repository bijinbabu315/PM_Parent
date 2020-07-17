package com.sba.pm.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.sba.pm.dao.impl.ParentTaskDaoImpl;
import com.sba.pm.entity.ParentTaskEntity;

@RunWith(SpringRunner.class)
public class ParentTaskServiceImplTest {
	
	@InjectMocks
    ParentTaskServiceImpl parentTaskServiceImpl;
    
    @Mock
    ParentTaskDaoImpl parentTaskDaoImpl;
    
   
   
	@Test
	public void test_createOrUpdate() throws Exception {
		Mockito.when(parentTaskDaoImpl.saveOrUpadte(createMockParentTaskList().get(0))).thenReturn(1);
		Assert.assertNotNull(parentTaskServiceImpl.saveOrUpadte(createMockParentTaskList().get(0)));		
	}
    
	@Test
	public void getAllParentTasks() throws Exception {
		Mockito.when(parentTaskDaoImpl.getAllParentTask()).thenReturn(createMockParentTaskList());
		Assert.assertNotNull(parentTaskServiceImpl.getAllParentTask()) ;
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