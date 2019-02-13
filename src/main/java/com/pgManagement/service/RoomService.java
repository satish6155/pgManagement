package com.pgManagement.service;

import java.util.List;

import com.pgManagement.entity.Room;

public interface RoomService {

	public void addRoom(Room room);

	public Room getRoomById(long id);

	public List<Room> getAllRoom();

	public void updateRoom(Room room);

	public void deleteRoom(long id);
}
