package com.pgManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgManagement.entity.master.ZipCode;
import com.pgManagement.service.ZipCodeServiceImpl;

@RestController
public class ZipCodeController {
	
	@Autowired
	private ZipCodeServiceImpl zipCodeServiceImpl;
	
	@RequestMapping(value="/getZipCodeByCode/{zipCode}",produces="application/json",
            method=RequestMethod.GET)
    public ZipCode getZipCodeByCode(@PathVariable("zipCode") Integer code)
    {
		System.out.println("In controller getZipCodeByCode code: "+code);
		
		ZipCode zipCode = zipCodeServiceImpl.getZipCodeByCode(code);
		System.out.println("In controller getZipCodeByCode, ZipCode : "+ zipCode );
        return zipCode;
    }

}
