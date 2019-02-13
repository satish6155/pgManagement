package com.pgManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pgManagement.entity.master.ZipCode;

@Repository("zipCodeDao")
public class ZipCodeDaoImpl implements ZipCodeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ZipCodeDaoImpl() {
		super();
	}

	@Override
	public void addZipCode(ZipCode zipCode) {
		entityManager.persist(zipCode);
	}

	@Override
	public ZipCode getZipCodeById(long id) {
		return entityManager.find(ZipCode.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ZipCode> getAllZipCode() {
		return entityManager.createQuery(
				"select zipCodes from ZipCode zipCodes").getResultList();
	}

	@Override
	public void updateZipCode(ZipCode zipCode) {
		entityManager.merge(zipCode);

	}

	@Override
	public void deleteZipCode(long id) {
		ZipCode zipCode = entityManager.find(ZipCode.class, id);
		entityManager.remove(zipCode);

	}

	@Override
	public ZipCode getZipCodeByCode(Integer code) {

		ZipCode zipCode = null;
		System.out.println("in ZipCodeDao");
		try{
			zipCode = (ZipCode) entityManager.createQuery("select zipCode from ZipCode zipCode where zipCode.zipCode = :code")
					.setParameter("code", code).getSingleResult();
		}catch(NoResultException nre){
		}		
		System.out.println(zipCode);
		return zipCode;
	}

}
