package com.pgManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.pgManagement.dao.ZipCodeDao;
import com.pgManagement.entity.master.ZipCode;

@Service("zipCodeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ZipCodeServiceImpl implements ZipCodeService {

	@Autowired
	private ZipCodeDao zipCodeDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addZipCode(ZipCode zipCode) {
		zipCodeDao.addZipCode(zipCode);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ZipCode getZipCodeById(long id) {
		return zipCodeDao.getZipCodeById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<ZipCode> getAllZipCode() {
		return zipCodeDao.getAllZipCode();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateZipCode(ZipCode zipCode) {
		zipCodeDao.updateZipCode(zipCode);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteZipCode(long id) {
		zipCodeDao.deleteZipCode(id);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ZipCode getZipCodeByCode(Integer code) {

		return zipCodeDao.getZipCodeByCode(code);
	}

}
