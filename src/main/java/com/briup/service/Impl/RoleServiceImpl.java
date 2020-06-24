package com.briup.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.dao.RoleDao;
import com.briup.service.IRoleService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年3月27日 下午2:43:52 
* 类说明 
*/
@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RoleDao dao;
	@Override
	public Page<Role> findAllRole() {
		return findAllRoles(0);
	}

	@Override
	public Page<Role> findAllRoles(Integer pageIndex) {
		//指定查看第几页数据，并且指定一页显示多少条数据。
		return dao.findAll(PageRequest.of(pageIndex, 2));
	}

	@Override
	public void savaRole(Role role) {
		dao.save(role);
	}

	@Override
	public Role findRoleById(Integer id) {
		
		return dao.getOne(id);
	}

	@Override
	public void deleteRole(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Role> AllRole() {
		return dao.findAll();
	}

}
