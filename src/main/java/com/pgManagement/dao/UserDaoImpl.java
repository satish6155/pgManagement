package com.pgManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pgManagement.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public UserDaoImpl() {
		super();
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User getUserById(long id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		return entityManager.createQuery("select users from User users")
				.getResultList();
	}

	@Override
	public void updateUser(User user) {
		System.out.println("In User DAO : updateUser"+ user.toString());
		entityManager.merge(user);

	}

	@Override
	public void deleteUser(long id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);

	}

	@Override
	public User validateUser(String username, String password) {

		User user = null;
		System.out.println("in UserDao");
		try {
			user = (User) entityManager
					.createQuery(
							"select users from User users where users.username = :uName and users.password= :passWord")
					.setParameter("uName", username)
					.setParameter("passWord", password).getSingleResult();
		} catch (NoResultException nre) {
		}

		System.out.println(user);

		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByCreatedBy(long createdById) {

		return entityManager
				.createQuery(
						"select users from User users where users.createdBy= :createdById ")
				.setParameter("createdById", createdById).getResultList();
	}

}
