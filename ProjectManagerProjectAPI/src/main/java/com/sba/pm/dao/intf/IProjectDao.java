package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.ProjectEntity;

public interface IProjectDao {
	
	public Integer saveOrUpdateProject(ProjectEntity projectEntity);

	public List<ProjectEntity> getAllProjects();

	public Integer delete(Integer id);
}
