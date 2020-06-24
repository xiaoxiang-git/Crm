package com.briup.service;
/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 下午3:21:04 
* 类说明 
*/

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;
import com.briup.bean.User;

public interface IPlanService {
	Page<Chance> findByUser(User plan,String adress);
	
	Page<Chance> findByUsers(User plan,String adress,Integer index);
}
