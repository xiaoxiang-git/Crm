package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 上午10:20:17 
* 类说明 
*/
@Controller
public class FeedbackController {
	@RequestMapping("toFeedback")
	public String show() {
		
		return "pages/feedback";
	}
}
