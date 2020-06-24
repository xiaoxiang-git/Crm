package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.IPlanService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 下午3:17:42 
* 类说明 
*/
@Controller
public class PlanController {
	User plan=null;
	@Autowired
	private IPlanService planService;
	
	@RequestMapping("toSalesPlan")
	public String show(HttpSession session,String address) {
		
		plan = (User) session.getAttribute("user");
//		System.err.println(address+"--");
		Page<Chance> plans = planService.findByUser(plan,address);
		//System.err.println(plan+"-------"+plans.getTotalPages());
		session.setAttribute("plans", plans);
		return "pages/plan";
	}
	//分页
	@RequestMapping("Page")
	public String page(HttpSession session,String address,Integer index) {
		//写到了分页，但是index没传过来  address是给后面查询地址留的参数
		//Page<Chance> plans = planService.findByUser(plan,adress);
//		System.err.println(address+"--"+index);
		Page<Chance> plans = planService.findByUsers(plan,address,index);
		session.setAttribute("plans", plans);
		return "pages/plan";
	}
	//显示添加计划页面
	@RequestMapping("toSalesPlanAdd")
	public String planAdd(HttpSession session,Integer id) {
//		System.err.println("id:"+id);
		session.setAttribute("id", id);
		return "pages/plan_add";
//		return "";
	}
}
