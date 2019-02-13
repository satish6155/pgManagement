package com.pgManagement.service;

import java.util.List;

import com.pgManagement.entity.User;

public interface UserService {

	public void addUser(User user);

	public User getUserById(long id);

	public List<User> getAllUser();

	public void updateUser(User user);

	public void deleteUser(long id);
	
	public User validateUser(String username, String password) ;
}
