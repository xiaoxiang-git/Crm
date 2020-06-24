package com.briup.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.CustomerConstitute;
import com.briup.service.ICustomerConstituteService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 上午10:35:53 
* 类说明 
*/
@Controller
public class CustomerConstituteController {
	@Autowired
	private ICustomerConstituteService service;
	
	@RequestMapping("toCustomerConstitute")
	public String show() {
		
		return "pages/customerConstitute";
	}
	
	@RequestMapping("regionAnalyze")
	@ResponseBody
	public List<CustomerConstitute> toregionAnalyze(){
		return service.regionAnalyze(); 
	}
	
	@RequestMapping("levelregionAnalyze")
	@ResponseBody
	public List<CustomerConstitute> tolevelregionAnalyze(){
		return service.levelAnalyze(); 
	}
}
