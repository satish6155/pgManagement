package com.pgManagement.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yo")
public class DummyController {
	
	
	@RequestMapping(value="/dummy", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public String createUser(@RequestBody String request)
    {
		
		System.out.println("In dummy controller");
		System.out.println(request);
		/*System.out.println("In controller after persisting");
		System.out.println(user);*/
		
		return "shabash!";
    }
	@RequestMapping(value="/test",produces="application/json",
            method=RequestMethod.GET)
    public String testConnection()
    {
		System.out.println("Request is successfull");
		return "You did it ;) ";
    }

}
