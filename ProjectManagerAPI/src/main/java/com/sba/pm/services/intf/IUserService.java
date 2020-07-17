package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;

public interface IUserService {
	public Integer saveOrUpdateUser(UserEntity userEntity);
	public Integer updateProjectInUser(ProjectEntity projectEntity);
	public List<UserEntity> getAllUsers();
	public Integer deleteUser(Integer id);
}
