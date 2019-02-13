package com.pgManagement.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.pgManagement.entity.Room;
import com.pgManagement.entity.User;

public class RoomRestClient {
	
	public static final String REST_BASE_URI = "http://localhost:8080/SpringRestHibernate";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String args[]) {
		addRoom();
	}
	public static void addRoom()
    {
		Room room = new Room();
		
    	User createdBy = new User();
    	createdBy.setId(1L);
    	
		    	
		room.setCode("G2");
		room.setCreatedBy(1L);
		room.setNoOfSeats(3);
			
		System.out.println(room);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<Room> entity = new HttpEntity<>(room,headers);
        System.out.println("Making request...");
        restTemplate.postForObject(REST_BASE_URI+"/addRoom", entity,Room.class);
        System.out.println("Success!!");
		
    }

}
