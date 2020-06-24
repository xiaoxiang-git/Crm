package com.briup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Chance;
import com.briup.bean.User;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月1日 下午2:17:39 
* 类说明 销售商机dao
*/
public interface ChanceDao extends JpaRepository<Chance, Integer>{
	Page<Chance> findByCustomerAndAddress(String customer,String address,Pageable index);
	
	//根据潜在客户名 查询对应的销售商机并分页List<Chance> findByAddress(String address);
	Page<Chance> findByCustomerLike(String customer,Pageable index);
	//根据地址 查询对应的销售商机并分页List<Chance> findByAddress(String address);
	Page<Chance> findByAddress(String address,Pageable index);
	//根据客户经理，查询对应的销售商机并分页
	Page<Chance> findByHandler(User handler,Pageable index);
	
	Page<Chance> findByCreator(User Creator,Pageable index);
	
	//根据客户经理和区域，一起查询对应的销售商机并分页
	Page<Chance> findByHandlerAndAddress(User handler,String address,Pageable index);
	
	
	
}
