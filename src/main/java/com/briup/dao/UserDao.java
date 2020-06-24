package com.briup.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.briup.bean.Role;
import com.briup.bean.User;

/** 
* @author 作者 kk: 
* @version 创建时间：2020年3月26日 下午4:53:54 
* 类说明 
*/
public interface UserDao extends JpaRepository<User, Integer>{
	User findByName(String name);
	//Page<User> findByRole(Role role);
	Page<User> findByRole(Role role,Pageable page);
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("delete from User u where u.id=?1") void deletuUserById(Integer id);
	 */
}
