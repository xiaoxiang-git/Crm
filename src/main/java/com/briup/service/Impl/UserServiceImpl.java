package com.briup.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.IUserService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年3月26日 下午4:51:26 
* 类说明 
*/
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public void savaUser(User user) {
		userDao.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.getOne(id);
	}

	@Override
	public void deleteUser(Integer id) {
	
		userDao.deleteById(id);
	}

	@Override
	public Page<User> findUsersByRole(Integer roleId) {
		
		return findUsersByRole(roleId,0);
	}

	@Override
	public Page<User> findUsersByRole(Integer roleId, Integer pageIndex) {
		Page<User> users = null;
		if(roleId==null) {
			users=userDao.findAll(PageRequest.of(pageIndex, 3));
		}else {
			Role role = new Role();
			role.setId(roleId);
			users =userDao.findByRole(role, PageRequest.of(pageIndex, 3));
		}
		return users;
	}




}
