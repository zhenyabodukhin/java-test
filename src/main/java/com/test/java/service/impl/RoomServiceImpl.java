package com.test.java.service.impl;

import com.test.java.exception.EntityNotFoundException;
import com.test.java.domain.Room;
import com.test.java.repository.RoomRepository;
import com.test.java.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Transactional
    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Transactional
    @Override
    public Room update(Room room) {
        return roomRepository.saveAndFlush(room);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if(roomRepository.findById(id).isPresent()) {
            roomRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Room.class, id);
        }
    }

    @Override
    public Room findById(Long id) {
        Optional<Room> result = roomRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new EntityNotFoundException(Room.class, id);
        }
    }

    @Override
    public Room findByName(String name) {
        return roomRepository.findByName(name);
    }
}
