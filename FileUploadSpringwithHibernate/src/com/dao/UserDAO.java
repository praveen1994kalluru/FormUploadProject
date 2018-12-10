package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entitys.User;
@Repository
public class UserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	public int saveUser(User user){
        int i=(int) hibernateTemplate.save(user);
		return i;
	}
}
