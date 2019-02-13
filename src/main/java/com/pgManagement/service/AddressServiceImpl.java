package com.pgManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pgManagement.dao.AddressDao;
import com.pgManagement.entity.Address;

@Service("addressService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addAddress(Address address) {
		return addressDao.addAddress(address);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Address getAddressById(long id) {
		return addressDao.getAddressById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Address> getAllAddressByUser(long id) {
		return addressDao.getAllAddressByUser(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean updateAddress(Address address) {
		return addressDao.updateAddress(address);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean deleteAddress(long id) {
		return addressDao.deleteAddress(id);
	}

}
