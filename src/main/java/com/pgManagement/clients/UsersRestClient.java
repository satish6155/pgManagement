package com.pgManagement.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.pgManagement.entity.Address;
import com.pgManagement.entity.User;
import com.pgManagement.entity.master.City;
import com.pgManagement.entity.master.Country;
import com.pgManagement.entity.master.State;
import com.pgManagement.entity.master.ZipCode;

public class UsersRestClient {

	public static final String REST_BASE_URI = "http://localhost:8080/SpringRestHibernate";

	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String args[]) {
		//addUser();
		//validateUser("satish","123");   
		//validateUser("chunnu","123"); 
		 User user= getUser(1);
		 
		 System.out.println("**** user with id : " + 1 + "****");
			System.out.println(user);
			/*System.out.println("Address :");
			System.out.println(user.getAddresses());*/	
			}
	
	

	/** POST **/
	public static void addUser()
    {
    	
    	User user= new User();
    	
    	City city = new City();
    	city.setId(496L);
    	
    	Country country = new Country();
    	country.setId(1L);
    	
    	State state = new State();
    	state.setId(1L);
    	
    	ZipCode zipCode = new ZipCode();
    	zipCode.setId(23005L);
    	
    	/*User createdBy = new User();
    	createdBy.setId(1L);*/
    	
    	
    	Address address1 = new Address();
    	address1.setAddressLine1("line1");
    	address1.setAddressLine2("line2");
    	address1.setZipCode(zipCode);
	    
	    Address address2 = new Address();
	    address2.setAddressLine1("line2.1");
    	address2.setAddressLine2("line2.2");
    	address2.setZipCode(zipCode);
		
	    List<Address> addresses = new ArrayList<Address>();
	    addresses.add(address1);
	    addresses.add(address2);
	    

    	
    	//user.setId((long) 111);
	    user.setUsername("hello1");
	    user.setPassword("123");
    	user.setFirstName("hello");
    	user.setLastName("Ji");
    	user.setMobileNumber(741254789);
    	user.setUsername("chunnu");
    	user.setCreatedBy(1l);
    	//user.setAddresses(addresses);
    	//user.setAddresses(addresses);
    	
    	System.out.println(user);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println("dfsdfsd");
        
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        HttpEntity<User> entity = new HttpEntity<>(user,headers);
        System.out.println("Making request...");
        restTemplate.postForObject(REST_BASE_URI+"/addUser", entity,User.class);
        System.out.println("Success!!");
    }

	private static User getUser(int id) {
		return restTemplate.getForObject(REST_BASE_URI + "/getUserById/" + id,
				User.class);
		
	}
	
	@SuppressWarnings("unused")
	private static void validateUser(String username, String password) {
		User user = restTemplate.getForObject(REST_BASE_URI + "/login/" + username+"/"+password,
				User.class);
		if(user==null){
			System.out.println("Wrong username or password!!!");
		}
		else{
			System.out.println(user);
		}
		
	}
	
/*	public static void getAllStudents()
    {
       

        List<Map<String, Object>> studentList = restTemplate.getForObject(REST_BASE_URI + "/students", List.class);
        if (studentList != null)
        {
            System.out.println("**** All Students ****");
            for (Map<String, Object> map : studentList)
            {
                System.out.println("Id : id=" + map.get("id") + "   Name=" + map.get("name") + "   Age="
                        + map.get("age"));
            }
        } else
        {
            System.out.println("No Students exist!!");
        }
    }*/

	
	
}
