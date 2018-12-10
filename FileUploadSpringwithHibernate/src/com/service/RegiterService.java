package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDAO;
import com.entitys.User;

@Service
@EnableTransactionManagement
public class RegiterService {
	@Autowired
	private UserDAO userDAO;
	@Transactional(readOnly=false)
  public int saveUSer(User user){
	  int i=userDAO.saveUser(user);
	  return i;
  }
}
