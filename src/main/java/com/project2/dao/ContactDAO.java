package com.project2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project2.models.Contact;





@Repository
public interface ContactDAO extends JpaRepository<Contact,Integer>{
	
	
	//Contact save(Contact contact);
	
	
	@Modifying
	@Query("delete from Contact c where contactlist_id = :id")
		void deleteContact(@Param("id")Integer id);
	
	
	
	@Query("select c from Contact c where c.userid = :userid")
		List<Contact> findAllContactsByUserid(@Param("userid")Integer userid);
	
	@Query("select c from Contact c where c.userid = :userid and c.contactlist_id = :contactid")
		Contact findByContactIdAndUserId(@Param("userid")Integer userid, @Param("contactid")Integer contactid);
	
}