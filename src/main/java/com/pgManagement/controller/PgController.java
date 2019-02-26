package com.pgManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgManagement.entity.Pg;
import com.pgManagement.entity.User;
import com.pgManagement.service.PgServiceImpl;
import com.pgManagement.service.UserServiceImpl;

@RestController
public class PgController {

	@Autowired
	private PgServiceImpl pgServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/saveNewPg", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Pg createPg(@RequestBody Pg pg) {

		System.out.println("In PG controller : createPg ");
		pgServiceImpl.addPg(pg);
		return pg;
	}

	@RequestMapping(value = "/getAllPg", produces = "application/json", method = RequestMethod.GET)
	public List<Pg> getAllPg() {

		List<Pg> pgs = new ArrayList<>();

		pgs = pgServiceImpl.getAllPg();
		System.out.println("In PG controller : getAllPg ");
		return pgs;
	}

	@RequestMapping(value = "/getPgByUser/{userId}", produces = "application/json", method = RequestMethod.GET)
	public List<Pg> getPgByUser(@PathVariable("userId") long userId) {

		List<Pg> pgs = new ArrayList<>();

		pgs = pgServiceImpl.getPgByUser(userId);
		System.out.println("In PG controller : getPgByUser ");
		return pgs;
	}
	
	@RequestMapping(value = "/getUnassignedPgs", produces = "application/json", method = RequestMethod.GET)
	public List<Pg> getUnassignedPgs() {

		List<Pg> pgs = new ArrayList<>();

		pgs = pgServiceImpl.getUnassignedPgs();
		System.out.println("In PG controller : getUnassignedPgs ");
		
		for (Pg pg : pgs){
			System.out.println("PG : "+pg.toString());			
		}
		return pgs;
	}
	 @RequestMapping(value = "/assignPgsToUser/userId/{userId}/pgCodes/{pgCodes}", produces = "application/json", method = RequestMethod.GET)
		public String assignPgsToUser(@PathVariable("userId") long userId, @PathVariable("pgCodes") String pgCodes) {
		 
		 User user = userServiceImpl.getUserById(userId);
		 StringTokenizer st = new StringTokenizer(pgCodes,",");  
	     while (st.hasMoreTokens()) {  
	    	 String pgCode = st.nextToken();
	    	// System.out.println("pgCode :"+pgCode);  
	    	 Pg pg = pgServiceImpl.getPgByCode(pgCode);
	    	 List <User> users = pg.getUsers();
	    	 users.add(user);
	    	 pg.setUsers(users);
	         System.out.println(pg.toString());
	         pgServiceImpl.updatePg(pg);
	     }  
	     return "200";

		}

	@RequestMapping(value = "/getPgById/{id}", produces = "application/json", method = RequestMethod.GET)
	public Pg getPgById(@PathVariable("id") long id) {
		System.out.println("In controller getUser ID: " + id);
		Pg pg = pgServiceImpl.getPgById(id);
		System.out.println("In controller getPgById, PG : " + pg.toString());
		return pg;
	}

	@RequestMapping(value = "/updatePg", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Pg updatePg(@RequestBody Pg pg) {

		System.out.println("In PG controller : updatePg ");
		pgServiceImpl.updatePg(pg);
		return pg;
	}

}
