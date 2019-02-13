package com.pgManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pgManagement.dao.UserDao;
import com.pgManagement.entity.User;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUser(long id) {
		userDao.deleteUser(id);

	}

	public User validateUser(String username, String password) {

		return userDao.validateUser(username, password);
	}

	public List<User> getUserByCreatedBy(long id) {
		return userDao.getUserByCreatedBy(id);
	}

}
