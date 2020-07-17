package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;

public interface IUserDao {
	public Integer saveOrUpdateUser(UserEntity user);

	public Integer updateProjectInUser(ProjectEntity projectEntity);

	public List<UserEntity> getAllUsers();

	public Integer deleteUser(Integer id);
}
