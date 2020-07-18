package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.UserEntity;
import com.sba.pm.request.ProjectUpdateRequest;

public interface IUserService {
	public Integer saveOrUpdateUser(UserEntity userEntity);
	public Integer updateProjectInUser(ProjectUpdateRequest projectUpdateRequest);
	public List<UserEntity> getAllUsers();
	public Integer deleteUser(Integer id);
	public UserEntity getUserById(String projectId);
}
