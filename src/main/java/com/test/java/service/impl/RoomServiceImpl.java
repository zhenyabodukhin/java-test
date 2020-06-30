package com.test.java.service.impl;

import com.test.java.domain.GeoIp;
import com.test.java.domain.Room;
import com.test.java.exception.EntityAlreadyExistException;
import com.test.java.exception.NoAccessException;
import com.test.java.repository.RoomRepository;
import com.test.java.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final GeoIpLocationService locationService;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Transactional
    @Override
    public Room save(Room room) {
        String name = room.getName();
        Room result = roomRepository.findByName(name);
        if (result == null) {
            return roomRepository.save(room);
        } else {
            throw new EntityAlreadyExistException(Room.class, name);
        }
    }

    @Transactional
    @Override
    public Room update(Room room) {
        return roomRepository.saveAndFlush(room);
    }

    @Override
    public Room findByName(String name) {
        return roomRepository.findByName(name);
    }

    @Override
    public Room getRoomByIp(String name, String ip) {
        Room selectedRoom = roomRepository.findByName(name);
        String roomCountry = selectedRoom.getCountryName();

        GeoIp geoCountry = locationService.getLocation(ip);
        String userCountry = geoCountry.getCountry();
        if (roomCountry.equals(userCountry)) {
            return selectedRoom;
        } else {
            throw new NoAccessException(Room.class, name);
        }
    }
}
