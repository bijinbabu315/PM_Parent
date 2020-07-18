package com.sba.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.services.impl.ProjectServiceImpl;


@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	
	@PostMapping("/project/saveOrUpdateProject")
	public Integer createOrUpdate(@RequestBody ProjectEntity projectEntity) {
		return projectService.saveOrUpdateProject(projectEntity);
	}
	
	@GetMapping("/project/getAllProjects")
	public List<ProjectEntity> getAllProjects(){
		return projectService.getAllProjects();
		
	}
	
	@DeleteMapping("/project/deleteProject/{id}")
	public Integer deleteProject(@PathVariable String id) {
		return projectService.delete(Integer.parseInt(id));
	}

}
