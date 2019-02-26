package com.pgManagement.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pgManagement.entity.Address;
import com.pgManagement.entity.Pg;
import com.pgManagement.entity.Room;
import com.pgManagement.entity.User;
import com.pgManagement.entity.master.ZipCode;

public class PgRestClient {

	public static final String REST_BASE_URI = "http://localhost:8090/SpringRestHibernate";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String args[]) {
		// addPg();
		getAllPg();
		//getPgById(50000L);
	}

	public static void addPg() {
		Pg pg = new Pg();

		ZipCode zipCode = new ZipCode();
		zipCode.setId(23005L);

		User createdBy = new User();
		createdBy.setId(1L);

		Address address1 = new Address();
		address1.setAddressLine1("line1");
		address1.setAddressLine2("line2");
		address1.setZipCode(zipCode);

		pg.setCode("abc");
		pg.setName("Raison PG");

		User pg_user = new User();
		pg_user.setId(1L);

		List<User> pg_users = new ArrayList<User>();
		pg_users.add(pg_user);

		Room room = new Room();
		room.setCode("1");
		// room.setId(50000L);

		List<Room> rooms = new ArrayList<Room>();
		rooms.add(room);

		pg.setAddress(address1);
		pg.setUsers(pg_users);
		pg.setRooms(rooms);

		System.out.println(pg);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Pg> entity = new HttpEntity<>(pg, headers);
		System.out.println("Making request...");
		restTemplate.postForObject(REST_BASE_URI + "/saveNewPg", entity,
				Pg.class);
		System.out.println("Success!!");

	}

	public static void getAllPg() {

		System.out.println("In PG client : Get All PG");
		// List<Pg> allPg = restTemplate.getForObject(REST_BASE_URI +
		// "/getAllPg", List.class);

		ResponseEntity<List<Pg>> response = restTemplate.exchange(REST_BASE_URI
				+ "/getAllPg", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Pg>>() {
				});
		List<Pg> allPg = response.getBody();
		for (Pg newPg : allPg) {
			System.out.println("PG :" + newPg.toString());

		}

	}

	public static void getPgById(Long id) {
		Pg pg = new Pg();
		pg = restTemplate.getForObject(REST_BASE_URI + "/getPgById/" + id,
				Pg.class);
		System.out.println("PG : "+pg.toString());

	}

}
