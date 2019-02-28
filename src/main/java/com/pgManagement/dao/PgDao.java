package com.pgManagement.dao;

import java.util.List;

import com.pgManagement.entity.Pg;

public interface PgDao {

	void addPg(Pg pg);

	Pg getPgById(long id);

	List<Pg> getAllPg();

	void updatePg(Pg pg);

	void deletePg(long id);

	List<Pg> getPgByUser(long id);

	List<Pg> getUnassignedPgs(long userid, long loggedUserid);

	Pg getPgByCode(String pgCode);

}
