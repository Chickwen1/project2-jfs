package com.project2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.dao.ContactDAO;
import com.project2.models.Contact;






@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	@Transactional
	public void newContact(Contact contact) {
		contactDAO.save(contact);
		
	}

	@Transactional
	public List<Contact> findAllContactsByUserid(Integer userid) {
		List<Contact> contact = null;
		contact = contactDAO.findAllContactsByUserid(userid);
		return contact;
	}

	@Transactional
	public Contact findByContactIdAndUserId(Integer userid, Integer contactid) {
		Contact contact = null;

		contact = contactDAO.findByContactIdAndUserId(userid,contactid);
		if (contact==null) {
			//throw new ServiceException("User id not found");
		}
		return contact;
	}

	@Transactional
	public void deleteContact(Integer id) {
		contactDAO.deleteContact(id);
		
	}
}
