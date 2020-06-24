package com.briup.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年3月27日 下午2:34:14 
* 类说明 
*/
public interface IRoleService {
	//查询刚进入角色管理模块的所有角色
	Page<Role> findAllRole();
	
	//查询指定页上的数据信息
	Page<Role> findAllRoles(Integer pageIndex);
	
	//新增  修改
	void savaRole(Role role);
	
	//通过id找到对应的Role
	Role findRoleById(Integer id);
	
	//删除
	void deleteRole(Integer id);
	
	//查询所有的角色
	List<Role> AllRole();
}
