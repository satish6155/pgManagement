package com.pgManagement.clients;

import org.springframework.web.client.RestTemplate;

import com.pgManagement.entity.master.ZipCode;

public class ZipCodeClient {

	public static final String REST_BASE_URI = "http://localhost:8080/SpringRestHibernate";

	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String args[]){
		ZipCode zipCode = getZipCodeByCode(400006);
		
		System.out.println(zipCode);
	}

	private static ZipCode getZipCodeByCode(Integer code) {
		
		return restTemplate.getForObject(REST_BASE_URI + "/getZipCodeByCode/"+code,ZipCode.class);
	}
}
