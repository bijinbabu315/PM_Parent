package com.sba.pm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pm.dao.impl.ParentTaskDaoImpl;
import com.sba.pm.entity.ParentTaskEntity;
import com.sba.pm.services.intf.IParentTaskService;

@Service("parentTaskService")
public class ParentTaskServiceImpl implements IParentTaskService {
	@Autowired
	ParentTaskDaoImpl parentTaskDao;

	@Override
	public Integer saveOrUpadte(ParentTaskEntity parentTaskEntity) {
		return parentTaskDao.saveOrUpadte(parentTaskEntity);
	}

	@Override
	public List<ParentTaskEntity> getAllParentTask() {
		return parentTaskDao.getAllParentTask();
	}


}
