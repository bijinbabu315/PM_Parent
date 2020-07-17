package com.sba.pm.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pm.dao.impl.TaskDaoImpl;
import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.TaskEntity;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.intf.ITaskService;



@Service("taskService")
public class TaskServiceImpl implements ITaskService {

	@Autowired
	TaskDaoImpl taskDao;
	
	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public Integer saveOrUpdateTask(TaskEntity taskEntity) {
		Integer result = taskDao.saveOrUpdateTask(taskEntity);
		if( result > 0 && taskEntity.getUserData() != null) {
			UserEntity userEntity = taskEntity.getUserData();
			userEntity.setProjectData(taskEntity.getProjectEntity());
			taskEntity.setProjectEntity(null);
			userEntity.setTaskData(taskEntity);
			userDao.saveOrUpdateUser(userEntity);
			}
		return result;
	}

	@Override
	public List<TaskEntity> getAllTasks() {
		return taskDao.getAllTasks();
		}


}
