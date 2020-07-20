package com.sba.pm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sba.pm.dao.impl.ProjectDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.request.ProjectUpdateRequest;
import com.sba.pm.services.intf.IProjectService;


@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	
//	@Autowired
	private ProjectDaoImpl projectDao;
	
//	@Autowired
	private Environment environment;
	
//	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	public ProjectServiceImpl(ProjectDaoImpl projectDao,
			RestTemplate restTemplate,
			Environment environment) {
		this.projectDao =projectDao;
		this.environment = environment;
		this.restTemplate = restTemplate;
	}
	

	@Override
	public Integer saveOrUpdateProject(ProjectEntity project) {
		Integer result = projectDao.saveOrUpdateProject(project);
		if( result > 0 && project.getUserId() != null) {
		ProjectUpdateRequest pr = new ProjectUpdateRequest();
		pr.setProjectID(project.getId());
		pr.setIsManager(1);
		pr.setUserID(project.getUserId());
		String apiURL = environment.getProperty("user.url");
		pr.setIsDelete(false);
		ResponseEntity<String> response = restTemplate.postForEntity(apiURL, pr, String.class);
		}
		
		return result;
	}

	@Override
	public List<ProjectEntity> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	public Integer delete(Integer id) {
		ProjectUpdateRequest pr = new ProjectUpdateRequest();
		pr.setProjectID(id);
		String apiURL = environment.getProperty("user.url");
		pr.setIsDelete(true);
		ResponseEntity<String> response = restTemplate.postForEntity(apiURL, pr, String.class);
		return projectDao.delete(id);
	}
}
