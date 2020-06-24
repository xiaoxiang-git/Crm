package com.briup.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.briup.bean.Chance;
import com.briup.bean.User;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月1日 下午2:16:26 
* 类说明 
*/
public interface IChanceService {
	void save(Chance chance);
	
	void delete(Integer id);
	
	Chance findChanceById(Integer id);
	
	
	//查询显示
	Page<Chance> findByCustomerAndAddress(String customer,String address,User handler);
	Page<Chance> findByCustomerAndAddress(String customer,String address,Integer index,User handler);
	
	Page<Chance> findChanceByHandler(User handler,Integer index);
}
