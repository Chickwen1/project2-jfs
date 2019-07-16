package com.project2.service;

import java.util.List;

import com.project2.models.Contact;



public interface ContactService {

	public List<Contact> findAllContactsByUserid(Integer userid);

	public void newContact(Contact contact);

	public Contact findByContactIdAndUserId(Integer userid, Integer contactid);

	public void deleteContact(Integer id);

}
