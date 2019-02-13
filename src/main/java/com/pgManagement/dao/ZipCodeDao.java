package com.pgManagement.dao;

import java.util.List;

import com.pgManagement.entity.master.ZipCode;



public interface ZipCodeDao {

	void addZipCode(ZipCode zipCode);

	ZipCode getZipCodeById(long id);

	List<ZipCode> getAllZipCode();

	void updateZipCode(ZipCode zipCode);

	void deleteZipCode(long id);

	ZipCode getZipCodeByCode(Integer code);

}
