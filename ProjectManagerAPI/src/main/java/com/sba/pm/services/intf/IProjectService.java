package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.ProjectEntity;

public interface IProjectService {
	
	public Integer saveOrUpdateProject(ProjectEntity project);

	public List<ProjectEntity> getAllProjects();

	public Integer delete(Integer id);
}
