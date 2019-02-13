package com.pgManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgManagement.entity.User;
import com.pgManagement.service.UserServiceImpl;

@RestController
public class AccessController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@RequestMapping(value="/login/{username}/{password}",produces="application/json",
            method=RequestMethod.GET)
    public User getStudentById(@PathVariable("username") String username,@PathVariable("password") String password)
    {
		System.out.println("In login controller");
		User user = userServiceImpl.validateUser(username,password);
        return user;
    }

}
