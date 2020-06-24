package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;
import com.briup.bean.User;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年3月26日 下午4:47:48 
* 类说明 
*/
public interface IUserService {
	
	public User findByName(String name);
		
		//新增  修改
		void savaUser(User user);
		
		//通过id找到对应的Role
		User findUserById(Integer id);
		
		//通过
		//删除
		void deleteUser(Integer id);
		
		//查询user信息
		Page<User> findUsersByRole(Integer roleId);
		//查询分页user 的相关信息
		Page<User> findUsersByRole(Integer roleId,Integer pageIndex);
}
