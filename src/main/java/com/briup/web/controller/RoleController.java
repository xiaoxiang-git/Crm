package com.briup.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年3月27日 上午11:50:59 
* 类说明 
*/
@Controller
public class RoleController {
	@Autowired
	private IRoleService service;
	
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		//将数据库中的所有角色信息查询出来
		Page<Role> roles = service.findAllRole();
		session.setAttribute("roles", roles);
		
		//System.err.println(roles.getTotalPages()+"------------");
		return "pages/role";
	}
	@RequestMapping("role/add")
	@ResponseBody
	public String sava(Role role) {
		/*
		 * Role role = new Role(); if(id!=null) { role.setId(id); } role.setName(name);
		 * role.setDescription(description); role.setFlag(flag); service.savaRole(role);
		 * if(id!=null) return "修改成功"; else { return "保存成功"; }
		 */
		if(role.getId()!=null) {
			service.savaRole(role);
			return "修改成功";
		}else {
			service.savaRole(role);
			return "保存成功";
		}
	}
	@RequestMapping("role/del")
	@ResponseBody
	public String del(Integer id) {
		service.deleteRole(id);
		return "删除成功";
	}
	
	@RequestMapping("role/page")
	public String page(Integer pageIndex,HttpSession session) {
		Page<Role> roles = service.findAllRoles(pageIndex);
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	
	@RequestMapping("findRoleById")
	@ResponseBody
	public Role findRoleById(Integer id) {
		return service.findRoleById(id);
	}

}
