package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.UserEntity;
import com.sba.pm.request.ProjectUpdateRequest;

public interface IUserDao {
	public Integer saveOrUpdateUser(UserEntity user);

	public Integer updateProjectInUser(ProjectUpdateRequest projectUpdateRequest);

	public List<UserEntity> getAllUsers();

	public Integer deleteUser(Integer id);

	UserEntity getUserById(String userId);
}
