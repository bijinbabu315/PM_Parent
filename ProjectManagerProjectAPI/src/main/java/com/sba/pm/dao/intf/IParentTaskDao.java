package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.ParentTaskEntity;

public interface IParentTaskDao {
	public Integer saveOrUpadte(ParentTaskEntity parentTaskEntity);

	public List<ParentTaskEntity> getAllParentTask();

}