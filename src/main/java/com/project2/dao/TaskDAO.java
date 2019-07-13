package com.project2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project2.models.Task;

public interface TaskDAO extends JpaRepository<Task,Integer> {

	Task save(Task task);

	@Query("select t from Task t")
	List<Task> list();
	
	@Query("select t from Task t where t.id = :taskId")
	Task findOne(@Param("taskId") Integer id);

	@Modifying
	@Query("delete from Task where id = :taskId")
	Task delete(@Param("taskId") Integer id);
	
//	@Query("select u from User u where u.email = :email and u.password = :password")
//	Task findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
