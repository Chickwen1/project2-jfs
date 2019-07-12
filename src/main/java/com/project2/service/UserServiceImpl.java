package com.project2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.dao.UserDAO;
import com.project2.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void registerUser(User user) {
		userDAO.save(user);
	}

	@Transactional
	public List<User> list() {
		return userDAO.list();
	}
	
	@Transactional
	public User findOne(Integer id) {
		return userDAO.findOne(id);
	}
	
	@Transactional
	public void delete(Integer id) {
		userDAO.delete(id);
	}

	@Override
	public void update(User user) {
		userDAO.save(user);
	}
}
