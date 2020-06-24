package com.briup.web.controller;
/** 
* @author 作者 kk: 
* @version 创建时间：2020年3月26日 下午4:32:05 
* 类说明 
*/


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.service.IRoleService;
import com.briup.service.IUserService;

@Controller
public class UserController {
	
	@Autowired 
	private IUserService service;
	
	@Autowired
	private IRoleService Roleservice;
	@RequestMapping("user/login")
	@ResponseBody
	public String login(String name,String password, HttpSession session) {
		//需要判断密码用户名是否为空，但是前台已经完成
		//调用servic层，判断用户名密码是否正确
		User user = service.findByName(name);
		//如果为空表示用户不存在
		if(user==null) {
			return "当前用户不存在!";
		}
		//判断密码是否正确
		if(!user.getPassword().equals(password)) {
			return "密码错误!";
		}
		//判断用户状态：1.为正常  2位注销
		if(user.getFlag()!=1) {
			return "该用户已注销！";
		}
		//将数据保存在session范围中，供前台使用
		session.setAttribute("user", user);
		//System.out.println(user);
		return "success";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	//点击用户管理显示
	@RequestMapping("toUser")
	public String toUser(Integer roleId,HttpSession session) {
		
		session.setAttribute("roleId", roleId);
		Page<User> users = service.findUsersByRole(roleId);
		session.setAttribute("users", users);
		
		List<Role> roles = Roleservice.AllRole();
		session.setAttribute("roles", roles);
		//System.err.println(roles);
		return "pages/user";
	}
	//分页查询
	@RequestMapping("updateUserPage")
	public String userPage(Integer pageIndex, HttpSession session) {
		Integer roleId = (Integer) session.getAttribute("roleId");
		Page<User> users = service.findUsersByRole(roleId, pageIndex);
		
		session.setAttribute("users", users);
		return "pages/user";
	}
	
	//重置功能
	@RequestMapping("resetUser")
	@ResponseBody
	public String resetUser(HttpSession session) {
		session.removeAttribute("roleId");
		return "重置成功";
	}
	
	@RequestMapping("user/save")
	@ResponseBody
	public String save(User user) {
		if(user.getId()==null) {
			service.savaUser(user);
			return "保存成功";
		}else {
			service.savaUser(user);
			return "修改成功";
		}
	}
	
	
	@RequestMapping("findUserById")
	@ResponseBody	
	public User findById(Integer id,HttpSession session) {
		User user = service.findUserById(id);
		//System.err.println(user);
		return service.findUserById(id);
	}
	
	@RequestMapping("user/dele")
	@ResponseBody
	public String deleUser(Integer id) {
		User user = service.findUserById(id);
		
		Integer roleId=user.getRole().getId();
		Role role = Roleservice.findRoleById(roleId);
		
		List<User> users = role.getUsers();
		users.remove(user);
		role.setUsers(users);
		
		Roleservice.savaRole(role);
		service.deleteUser(id);
	
		return "删除成功";
	}
	
	
}
