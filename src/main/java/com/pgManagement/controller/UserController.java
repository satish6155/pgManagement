package com.pgManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgManagement.entity.User;
import com.pgManagement.service.AddressServiceImpl;
import com.pgManagement.service.UserServiceImpl;


@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public User createUser(@RequestBody User user)
    {
		
		System.out.println("In controller");
		System.out.println(user);
		userServiceImpl.addUser(user);
		System.out.println("In controller after persisting");
		System.out.println(user);
		return user;
    }
	@RequestMapping(value = "/getAllUsers", produces = "application/json", method = RequestMethod.GET)
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		users = userServiceImpl.getAllUser();
		System.out.println("In USER controller : getAllUsers ");
		for (User user : users){
			System.out.println("user"+user.toString());
		}
		
		return users;
	}
	
	@RequestMapping(value="/getUserById/{id}",produces="application/json",
            method=RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id)
    {
		System.out.println("In controller getUser ID: "+id);
		User user = userServiceImpl.getUserById(id);
		System.out.println("In controller getUser, User : "+ user );
        return user;
    }
	
	@RequestMapping(value="/getUserByCreatedBy/{id}",produces="application/json",
            method=RequestMethod.GET)
    public List<User> getUserByCreatedBy(@PathVariable("id") long id)
    {
		System.out.println("In controller getUserByCreatedBy ID: "+id);
		List<User> users = new ArrayList<>();
		users = userServiceImpl.getUserByCreatedBy(id);
		for (User user : users){
			System.out.println("user"+user.toString());
		}
        return users;
    }
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public User updateUser(@RequestBody User user) {

		System.out.println("In User controller : updateUser ");
		userServiceImpl.updateUser(user);
		return user;
	}
	
	
	
	//////////////////////////Not used methods below------------------------------------------
	@RequestMapping(value="/addUserApp", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public User createUserApp(@RequestBody User user)
    {
		System.out.println("In request :"+user.toString());
		userServiceImpl.addUser(user);
		
		System.out.println("Out response :"+user.toString());
		return user;		
    }
	@RequestMapping(value="/appDummy", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public String createUserApp(@RequestBody String request)
    {
		System.out.println("In request :"+request);
		
		return "yo yo";		
    }
	@RequestMapping(value="/test",produces="application/json",
            method=RequestMethod.GET)
    public String testConnection()
    {
		System.out.println("Request is successfull");
		return "yo";
    }
	
	
	
	/////////////////////////////////////////////////////////////
	

}
