package com.briup.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Customer;
import com.briup.bean.CustomerConstitute;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerConstituteService;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年4月3日 上午10:44:47 
* 类说明 
*/
@Service
public class CustomerConstituteServiceImpl implements ICustomerConstituteService{
	
	@Autowired
	CustomerDao dao;
	
	
	@Override
	public List<CustomerConstitute> regionAnalyze() {
		// TODO Auto-generated method stub
		ArrayList<CustomerConstitute> list = new ArrayList<CustomerConstitute>();
		//从数据库将所有客户信息查找出来.(总数)
		int nums = dao.findAll().size();
		String[] regions = {"华中","华南","华东","华北"};
		//然后根据地区进行筛选  ， 封装成list 自定义对象
		for (String region : regions) {
			float num = dao.findByRegion(region).size();
			//获取百分比
			float y =num/nums *100;
			CustomerConstitute cc =new CustomerConstitute(region,y,region);
			
			list.add(cc);
		}
		
		return list;
	}

	@Override
	public List<CustomerConstitute> levelAnalyze() {
		ArrayList<CustomerConstitute> list = new ArrayList<CustomerConstitute>();
		int nums = dao.findAll().size();
		String[] levels = {"普通客户","大客户","重点开发客户","合作伙伴","战略合作伙伴"};
		for (String level : levels) {
			float num = dao.findByLevel(level).size();
			float y =num/nums *100;
			CustomerConstitute lcc =new CustomerConstitute(level,y,level);
			list.add(lcc);
		}
		return list;
	}

}
