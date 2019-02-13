package com.pgManagement.service;

import java.util.List;

import com.pgManagement.entity.master.ZipCode;

public interface ZipCodeService {

	public void addZipCode(ZipCode zipCode);

	public ZipCode getZipCodeById(long id);

	public List<ZipCode> getAllZipCode();

	public void updateZipCode(ZipCode zipCode);

	public void deleteZipCode(long id);
	
	public ZipCode getZipCodeByCode(Integer code);

}
