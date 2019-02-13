package com.pgManagement.dao;

import java.util.List;

import com.pgManagement.entity.User;


public interface UserDao {
	
	public void addUser(User user);
	
	public User getUserById(long id);
	
	public List<User> getAllUser();
	
	public void updateUser(User user);
	
	public void deleteUser(long id);

	public User validateUser(String username, String password);

	public List<User> getUserByCreatedBy(long id);

}
