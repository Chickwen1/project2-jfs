package com.project2.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.models.User;
import com.project2.service.UserService;
import com.project2.util.JavaMailUtil;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/adduser")                            
	public @ResponseBody ResponseEntity<Object> registertwo(@RequestBody User user) {      
		System.out.println("UserController->save");
		userService.registertwo(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

	@PostMapping()
	public @ResponseBody ResponseEntity<Object> register(@RequestBody User user) {
		System.out.println("UserController->save");
		userService.registerUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public @ResponseBody ResponseEntity<Object> login(@RequestBody User user) {
		System.out.println("UserController->login" + user.getEmail()  +"," + user.getPassword() );
		User u = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		System.out.println(u.getUserId());
		return new ResponseEntity<>(u ,HttpStatus.OK);
	}
	
	
	
	
	                          //put has the update ability use the add user ability
	@PutMapping("/{id}")                //update ability    //this id name is just a place holder for this method
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody User user) {         //this is asking for user object and integer
		System.out.println("UserController->update " + id);
		userService.update(user);
	}
	
	
	
    //user is assumed
    @PutMapping("update/{id}")             //update ability    //this id name is just a place holder for this method
    public @ResponseBody void userupdate(@PathVariable("id") Integer id,@RequestBody User user) {                //this is asking for user object and integer
	System.out.println("UserController->update " + id);                          
	userService.update(user);         //userupdate
}

	
	
	
	
	

	@GetMapping()
	public List<User> list() {
		List<User> list = userService.list();
		return list;
	}

//	@GetMapping("/{id}")
//	public User findOne(@PathVariable("id") Integer id) {
//		User user = userService.findOne(id);
//		return user;
//	}
	
	@GetMapping("welcome/{id}")                                   //voiloa=tion of rest api but fine for right now
	public User findOne(@PathVariable("id") Integer id) {
		User user = userService.findOne(id);
		return user;
	}
	
	
	
	@GetMapping("/{email}")
	public ResponseEntity<Object> findEmail(@PathVariable("email") String email) throws Exception {
		User u = userService.resendPassword(email);
		if (u != null) {
			//JavaMailNewEmp.sendNewEmployeeMail("miss.iserah@gmail.com", empEmail, newPassword, firstName, lastName);

			JavaMailUtil.resendPassword("miss.iserah@gmail.com", u.getPassword());
			return new ResponseEntity<Object>(u ,HttpStatus.OK);
		}
		return new ResponseEntity<Object>(u ,HttpStatus.NOT_FOUND);
		
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);

	}
	
	
	
	@DeleteMapping("welcome/{id}")          //capture the delete ability from the welcome page                                   //specfic id is given when in the welcome page
	public void deletesecond(@PathVariable("id") Integer id) {
		userService.delete(id);

	}
	
	
	
	
}
