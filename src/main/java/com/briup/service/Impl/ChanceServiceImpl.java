package com.briup.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.dao.ChanceDao;
import com.briup.service.IChanceService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月1日 下午2:17:02 
* 类说明 
*/
@Service
public class ChanceServiceImpl implements IChanceService{
	
	@Autowired
	private ChanceDao dao;
	@Override
	public void save(Chance chance) {
		dao.save(chance);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Page<Chance> findByCustomerAndAddress(String customer, String address,User handler) {
		return findByCustomerAndAddress(customer,address,0,handler);
	}

	@Override
	public Page<Chance> findByCustomerAndAddress(String customer, String address, Integer index, User handler) {
		if((customer==null||customer.trim()=="")&&(address==null||address.trim()=="")) {
			return dao.findAll(PageRequest.of(index, 2));
			//System.out.println(handler);
			//return dao.findByCreator(handler, PageRequest.of(index, 2));
		}else if((customer!=null&&customer.trim()!="")&&(address!=null&&address.trim()!="")){
			return dao.findByCustomerAndAddress(customer, address, PageRequest.of(index, 2));
		}else if(customer!=null&&customer.trim()!=""){
			customer="%"+customer+"%";
			return dao.findByCustomerLike(customer, PageRequest.of(index, 2));
		}else  {
			return dao.findByAddress(address, PageRequest.of(index, 2));
		}
		//if(address!=null&&address.trim()!="")
	}

	@Override
	public Chance findChanceById(Integer id) {
		//Optional<Chance> optional = dao.findById(id);
		return 	dao.getOne(id);
	}

	@Override
	public Page<Chance> findChanceByHandler(User handler, Integer index) {
		
		return dao.findByHandler(handler,  PageRequest.of(index, 2));
	}


	
	
}
