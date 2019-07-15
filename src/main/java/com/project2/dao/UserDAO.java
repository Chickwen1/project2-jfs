package com.project2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project2.models.User;



public interface UserDAO extends JpaRepository<User,Integer>{

	User save(User user);

	@Query("select u from User u")
	List<User> list();
	
	@Query("select u from User u where u.id = :userId")
	User findOne(@Param("userId") Integer id);

	@Modifying
	@Query("delete from User where id = :userId")
	void delete(@Param("userId") Integer id);
	
	@Query("select u from User u where u.email = :email and u.password = :password")
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Query("select u from User u where u.email = :email")
	User resendPassword(@Param("email")String email);

}