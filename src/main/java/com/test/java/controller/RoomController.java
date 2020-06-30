package com.test.java.controller;

import com.test.java.domain.Room;
import com.test.java.request.RoomCreateRequest;
import com.test.java.request.RoomUpdateRequest;
import com.test.java.service.impl.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomServiceImpl roomService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Room>> getAllRooms() {
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> createRoom(@RequestBody @Valid RoomCreateRequest request) {
        Room room = new Room();

        room.setName(request.getRoomName());
        room.setCountryName(request.getCountryName());

        return new ResponseEntity<>(roomService.save(room), HttpStatus.OK);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> getIntoRoom(@RequestBody @Valid RoomUpdateRequest request) {
        return new ResponseEntity<>(roomService.getRoomByIp(request.getCountryName(), request.getIp()), HttpStatus.OK);
    }

    @GetMapping("/get/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> setLight(String roomName, String lightStatus) {
        Room room = roomService.findByName(roomName);

        room.setLightStatus(lightStatus);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }
}
