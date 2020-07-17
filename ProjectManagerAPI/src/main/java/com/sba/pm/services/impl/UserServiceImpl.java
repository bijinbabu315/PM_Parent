package com.sba.pm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.intf.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	UserDaoImpl userDao;

	@Override
	public Integer saveOrUpdateUser(UserEntity user) {
		return userDao.saveOrUpdateUser(user);
	}

	@Override
	public Integer updateProjectInUser(ProjectEntity projectEntity) {
		return userDao.updateProjectInUser(projectEntity);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public Integer deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

}
