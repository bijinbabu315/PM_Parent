package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.TaskEntity;

public interface ITaskService {
	
	public Integer saveOrUpdateTask(TaskEntity taskEntity);

	public List<TaskEntity> getAllTasks();

}
