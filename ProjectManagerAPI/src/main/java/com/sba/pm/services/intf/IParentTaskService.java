package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.ParentTaskEntity;

public interface IParentTaskService {

	public Integer saveOrUpadte(ParentTaskEntity parentTaskEnity);
	public List<ParentTaskEntity> getAllParentTask();
	
}
