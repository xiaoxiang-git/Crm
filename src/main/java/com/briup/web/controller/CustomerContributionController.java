package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 下午2:50:00 
* 类说明 
*/
@Controller
public class CustomerContributionController {

	@RequestMapping("toCustomerContribution")
	public String show() {
		
		return "pages/customerContribution";
	}
	
	
	
}
