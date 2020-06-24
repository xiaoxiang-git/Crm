package com.briup.service;

import java.util.List;

import com.briup.bean.CustomerConstitute;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 上午10:44:07 
* 类说明 
*/
public interface ICustomerConstituteService {
	//地区分
	List<CustomerConstitute> regionAnalyze();
	
	//等级分
	List<CustomerConstitute> levelAnalyze();
	
	
	
}
