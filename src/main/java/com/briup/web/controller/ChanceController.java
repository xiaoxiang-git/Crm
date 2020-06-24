package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.dao.ChanceDao;
import com.briup.service.IChanceService;
import com.briup.service.IRoleService;
import com.briup.service.IUserService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月1日 下午2:15:23 
* 类说明 :销售商机controller类
*/
@Controller
public class ChanceController {
	
	@Autowired
	private IChanceService service;
	@Autowired
	private IRoleService roleservice;
	@Autowired
	private IUserService userservice;
	@RequestMapping("toSales")
	public String show(String customer,String address,HttpSession session) {
		//
		User user = (User) session.getAttribute("user");
		Page<Chance> chances = service.findByCustomerAndAddress(customer, address,user);
		session.setAttribute("chances", chances);
	//	session.setAttribute("customer", customer);
	//	session.setAttribute("address", address);
		
		Role findRoleById = roleservice.findRoleById(4);
		List<User> users = findRoleById.getUsers();
		session.setAttribute("users", users);
		
		return "pages/sales";
	}
	
	@RequestMapping("toPage")
	public String page(String customer,String address,Integer index,HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		Page<Chance> chances = service.findByCustomerAndAddress(customer, address, index,user);
		session.setAttribute("chances", chances);
		return "pages/sales";
	}
	@RequestMapping("chance/save")
	@ResponseBody
	public String sava(Chance chance) {
		//System.err.println(chance);
		if(chance.getId()!=null) {
			service.save(chance);
			return "修改成功";
		}else {
			service.save(chance);
			return "保存成功";
		}
	}
	@RequestMapping("chance/edit")
	@ResponseBody
	public Chance edit(Integer id, HttpSession session) {
		Chance chance = service.findChanceById(id);
		//Integer id2 = chance.getHandler().getId();
		//User editUser = userservice.findUserById(id2);
		//User editUser = service.findUserByid(id);
		//session.setAttribute("editUser", editUser);
		//System.out.println(editUser);
		return chance;
	}
	
	@RequestMapping("chance/dele")
	@ResponseBody
	public String dele(Integer id) {
		service.delete(id);
		return "删除成功";
	}
	
	
	@RequestMapping("chance/select")
	@ResponseBody
	public int edit2(Integer id) {
		Chance chance = service.findChanceById(id);
		Integer id2 = chance.getHandler().getId();
		User editUser = userservice.findUserById(id2);
		return editUser.getId();
	}
}
