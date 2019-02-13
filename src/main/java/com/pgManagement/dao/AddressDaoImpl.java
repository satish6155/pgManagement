package com.pgManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pgManagement.entity.Address;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public boolean addAddress(Address address) {
		entityManager.persist(address);
		return true;
	}

	@Override
	public Address getAddressById(long id) {
		return null;
	}
	
	@Override
	public List<Address> getAllAddressByUser(long id) {
		return null;
	}

	@Override
	public boolean updateAddress(Address address) {
		entityManager.merge(address);
		return true;
	}

	@Override
	public boolean deleteAddress(long id) {
		Address address = entityManager.find(Address.class,id);
		entityManager.remove(address);
		return true;
	}

	

}
