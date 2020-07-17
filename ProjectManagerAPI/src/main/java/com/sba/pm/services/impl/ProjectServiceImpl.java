package com.sba.pm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pm.dao.impl.ProjectDaoImpl;
import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.intf.IProjectService;


@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private ProjectDaoImpl projectDao;
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public Integer saveOrUpdateProject(ProjectEntity project) {
		Integer result = projectDao.saveOrUpdateProject(project);
		if( result > 0 && project.getUser() != null) {
		UserEntity userEntity = project.getUser().get(0);
		userEntity.setProjectData(project);
		userEntity.setIsManager(1);
		userDaoImpl.saveOrUpdateUser(userEntity);
		}
		
		return result;
	}

	@Override
	public List<ProjectEntity> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	public Integer delete(Integer id) {
		return projectDao.delete(id);
	}
}
