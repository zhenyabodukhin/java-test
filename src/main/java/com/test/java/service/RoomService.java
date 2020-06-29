package com.test.java.service;

import com.test.java.domain.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room save (Room room);

    Room update (Room room);

    Room findByName (String name);

    Room getRoomByIp (String name, String ip);
}
