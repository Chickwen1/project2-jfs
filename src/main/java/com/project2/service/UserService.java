package com.project2.service;
import java.util.List;

import com.project2.models.User;



public interface UserService {

	void registerUser(User user);

	void registertwo(User user);
	
	List<User> list();
	
	User findOne(Integer id);

	void delete(Integer id);
    
	void deletesecond(Integer id);
	
	void update(User user);

	void userupdate(Integer id,User user);
	
	
	
	User findByEmailAndPassword(String email, String password);

	User resendPassword(String email);
}
