package com.pgManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pgManagement.entity.Pg;

@Repository("pgDao")
public class PgDaoImpl implements PgDao {

	@PersistenceContext
	private EntityManager entityManager;

	public PgDaoImpl() {
		super();
	}

	@Override
	public void addPg(Pg pg) {
		entityManager.persist(pg);
	}

	@Override
	public Pg getPgById(long id) {
		return entityManager.find(Pg.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pg> getAllPg() {
		return entityManager.createQuery("select pgs from Pg pgs")
				.getResultList();
	}

	@Override
	public void updatePg(Pg pg) {
		entityManager.merge(pg);

	}

	@Override
	public void deletePg(long id) {
		Pg pg = entityManager.find(Pg.class, id);
		entityManager.remove(pg);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pg> getPgByUser(long id) {
		try {
			return entityManager
					.createQuery(
							"select pgs from Pg pgs join pgs.users u where u.id = :u_id")
					.setParameter("u_id", id).getResultList();
		} catch (NoResultException nre) {
			return null;
		}

	}

}
