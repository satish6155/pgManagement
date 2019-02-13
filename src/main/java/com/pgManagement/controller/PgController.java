package com.pgManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgManagement.entity.Pg;
import com.pgManagement.service.PgServiceImpl;

@RestController
public class PgController {

	@Autowired
	private PgServiceImpl pgServiceImpl;

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
