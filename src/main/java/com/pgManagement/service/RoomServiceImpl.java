package com.pgManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pgManagement.dao.RoomDao;
import com.pgManagement.entity.Room;

@Service("roomService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDao roomDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRoom(Room room) {
		roomDao.addRoom(room);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Room getRoomById(long id) {
		return roomDao.getRoomById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Room> getAllRoom() {
		return roomDao.getAllRoom();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateRoom(Room room) {
		roomDao.updateRoom(room);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteRoom(long id) {
		roomDao.deleteRoom(id);

	}

}
