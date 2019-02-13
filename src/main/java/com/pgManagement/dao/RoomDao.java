package com.pgManagement.dao;

import java.util.List;

import com.pgManagement.entity.Room;

public interface RoomDao {

	void addRoom(Room room);

	Room getRoomById(long id);

	List<Room> getAllRoom();

	void updateRoom(Room room);

	void deleteRoom(long id);

}
