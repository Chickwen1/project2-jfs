package com.project2.service;
import java.util.List;

import com.project2.models.User;



public interface UserService {

	void registerUser(User user);

	List<User> list();
	
	User findOne(Integer id);

	void delete(Integer id);

	void update(User user);

	User findByEmailAndPassword(String email, String password);

	User resendPassword(String email);
}
