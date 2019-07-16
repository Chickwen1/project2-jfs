package com.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.models.Contact;
import com.project2.service.ContactService;






@RestController
@RequestMapping("contact")
public class ContactController {

	
	@Autowired
	private ContactService contactService;
	
	@PostMapping()
	public void addContact(@RequestBody Contact contact) {
		System.out.println("ContactController->save");
		contactService.newContact(contact);
		
	}
	
	@GetMapping("/{userid}")
	public List<Contact> findAllContactsByUserid(@PathVariable("userid")Integer userid) {
		List<Contact> contacts = null;
		System.out.println("findAllContactsByUserid: " + userid);
		contacts = contactService.findAllContactsByUserid(userid);
		return contacts;
	}
	
	@GetMapping("/{userid}/{contactid}")
	public Contact findByContactIdAndUserId(@PathVariable("userid")Integer userid,@PathVariable("contactid")Integer contactid) {
		System.out.println("findByContactIdAndUserId: " + userid + "-" + contactid);
		Contact list = contactService.findByContactIdAndUserId(userid, contactid);
		return list;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")Integer id) {
		contactService.deleteContact(id);
	}

}
