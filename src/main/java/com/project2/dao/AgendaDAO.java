package com.project2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project2.models.Agenda;
import com.project2.models.Task;
import com.project2.models.User;

public interface AgendaDAO extends JpaRepository<Agenda, Integer>{

	Agenda save(Agenda agenda);
	
	@Query("select a from Agenda a")
	List<Agenda> list();
	
	@Query("select a from Agenda a where a.id = :agendaId")
	Agenda findOne(@Param("agendaId") Integer id);

	@Modifying
	@Query("delete from Agenda where id = :agendaId")
	int delete(@Param("agendaId") int id);
//	
//	@Query("select u from User u where u.email = :email and u.password = :password")
//	Agenda findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
