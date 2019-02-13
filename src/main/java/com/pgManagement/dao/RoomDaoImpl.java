package com.pgManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pgManagement.entity.Room;

@Repository("roomDao")
public class RoomDaoImpl implements RoomDao {

	@PersistenceContext
	private EntityManager entityManager;

	public RoomDaoImpl() {
		super();
	}

	@Override
	public void addRoom(Room room) {
		entityManager.persist(room);
	}

	@Override
	public Room getRoomById(long id) {
		return entityManager.find(Room.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getAllRoom() {
		return entityManager.createQuery("select rooms from Room rooms")
				.getResultList();
	}

	@Override
	public void updateRoom(Room room) {
		entityManager.merge(room);

	}

	@Override
	public void deleteRoom(long id) {
		Room room = entityManager.find(Room.class, id);
		entityManager.remove(room);

	}

}
