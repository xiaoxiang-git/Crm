package com.briup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.Plan;
import com.briup.bean.User;
import com.briup.dao.ChanceDao;
import com.briup.dao.PlanDao;
import com.briup.service.IPlanService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 下午3:21:18 
* 类说明 
*/
@Service
public class PlanServiceImpl implements IPlanService{
	
	@Autowired
	private PlanDao planDao;
	
	@Autowired
	private ChanceDao chanceDao;
	
	@Override
	public Page<Chance> findByUser(User plan,String address) {
	
		//return 
		return findByUsers(plan,address,0);
	}

	@Override
	public Page<Chance> findByUsers(User plan,String address, Integer index) {
		// TODO Auto-generated method stub
		if(address==null||address=="") {
			return chanceDao.findByHandler(plan, PageRequest.of(index, 2));
		}else{
			return chanceDao.findByHandlerAndAddress(plan, address, PageRequest.of(index, 1));
		}
	}
	
}
