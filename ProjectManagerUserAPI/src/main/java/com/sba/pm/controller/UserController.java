package com.sba.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pm.entity.UserEntity;
import com.sba.pm.request.ProjectUpdateRequest;
import com.sba.pm.services.impl.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/saveOrUpdateUser")
	public Integer createOrUpdate(@RequestBody UserEntity userEntity) {
		return userService.saveOrUpdateUser(userEntity);
	}
	
	@GetMapping("/getAllUsers")
	public List<UserEntity> getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public Integer deleteUser(@PathVariable String id) {
		return userService.deleteUser(Integer.parseInt(id));
	}

	
	@PostMapping("/updateProjectInUser")
	public Integer updateProjectInUser(@RequestBody ProjectUpdateRequest projectUpdateRequest) {
		System.err.println("request coming+++++++++++++");
		return userService.updateProjectInUser(projectUpdateRequest);
		
	}

}
