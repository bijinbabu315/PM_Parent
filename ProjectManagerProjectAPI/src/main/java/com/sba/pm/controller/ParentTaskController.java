package com.sba.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pm.entity.ParentTaskEntity;
import com.sba.pm.services.impl.ParentTaskServiceImpl;


@RestController
@CrossOrigin(origins = "*")
public class ParentTaskController {
	
	@Autowired
	private  ParentTaskServiceImpl parentTaskService;

	@PostMapping("/parentTask/saveOrUpdateParentTask")
	public Integer createOrUpdate(@RequestBody ParentTaskEntity parentTaskEntity) {
		return parentTaskService.saveOrUpadte(parentTaskEntity);
	}
	
	@GetMapping("/parentTask/getAllParentTasks")
	public List<ParentTaskEntity> getAllParentTask(){
		return parentTaskService.getAllParentTask();
		
	}
	
}
