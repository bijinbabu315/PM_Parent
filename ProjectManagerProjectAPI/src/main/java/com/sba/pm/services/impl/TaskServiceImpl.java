package com.sba.pm.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sba.pm.dao.impl.TaskDaoImpl;
import com.sba.pm.entity.TaskEntity;
import com.sba.pm.request.ProjectUpdateRequest;
import com.sba.pm.services.intf.ITaskService;



@Service("taskService")
public class TaskServiceImpl implements ITaskService {

//	@Autowired
	TaskDaoImpl taskDao;
	
//	@Autowired
	private Environment environment;
	
//	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	public TaskServiceImpl(TaskDaoImpl taskDao,
			RestTemplate restTemplate,
			Environment environment) {
		this.taskDao =taskDao;
		this.environment = environment;
		this.restTemplate = restTemplate;
	}
	
	
	@Override
	public Integer saveOrUpdateTask(TaskEntity taskEntity) {
		Integer result = taskDao.saveOrUpdateTask(taskEntity);
		if( result > 0 && taskEntity.getUserId() != null) {
			ProjectUpdateRequest pr = new ProjectUpdateRequest();
			pr.setProjectID(taskEntity.getProjectEntity().getId());
			pr.setTaskID(taskEntity.getId());
			pr.setIsDelete(false);
			pr.setUserID(taskEntity.getUserId());
			String apiURL = environment.getProperty("user.url");
			restTemplate.postForEntity(apiURL, pr, String.class);
			result = 1;
			}
		return result;
	}

	@Override
	public List<TaskEntity> getAllTasks() {
		return taskDao.getAllTasks();
		}


}
