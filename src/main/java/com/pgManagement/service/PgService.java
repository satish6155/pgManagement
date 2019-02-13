package com.pgManagement.service;

import java.util.List;

import com.pgManagement.entity.Pg;

public interface PgService {
	
	public void addPg(Pg pg);

	public Pg getPgById(long id);

	public List<Pg> getAllPg();

	public void updatePg(Pg pg);

	public void deletePg(long id);

}
