package com.pgManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgManagement.entity.Room;
import com.pgManagement.service.RoomServiceImpl;

@RestController
public class RoomController {
	
	@Autowired
	private RoomServiceImpl roomServiceImpl;
	
	@RequestMapping(value="/addRoom", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
	public void createRoom(@RequestBody Room room)
    {
		
		System.out.println("In Room controller : createRoom ");
		roomServiceImpl.addRoom(room);
    }
	
	
	

}
