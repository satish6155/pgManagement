package com.pgManagement.dao;

import java.util.List;

import com.pgManagement.entity.Address;

public interface AddressDao {
	
	public boolean addAddress(Address address);
	
	public Address getAddressById(long id);
	
	public List<Address> getAllAddressByUser(long id);
	
	public boolean updateAddress(Address address);
	
	public boolean deleteAddress(long id);

}
