package com.pgManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pgManagement.dao.PgDao;
import com.pgManagement.entity.Pg;

@Service("pgService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PgServiceImpl implements PgService {
	
	@Autowired
	private PgDao pgDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPg(Pg pg) {
		pgDao.addPg(pg);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Pg getPgById(long id) {
		return pgDao.getPgById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Pg> getAllPg() {
		return pgDao.getAllPg();
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Pg> getPgByUser(long id) {
		return pgDao.getPgByUser(id);
	}	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePg(Pg pg) {
		pgDao.updatePg(pg);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePg(long id) {
		pgDao.deletePg(id);

	}

	public List<Pg> getUnassignedPgs(long userid, long loggedUserid) {
		
		return pgDao.getUnassignedPgs(userid,loggedUserid);
	}

	public Pg getPgByCode(String pgCode) {
		return pgDao.getPgByCode(pgCode);
	}

}
