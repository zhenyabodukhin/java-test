package com.test.java.controller;

import com.test.java.domain.GeoIp;
import com.test.java.domain.Room;
import com.test.java.request.RoomCreateRequest;
import com.test.java.request.RoomGetRequest;
import com.test.java.service.impl.GeoIpLocationService;
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

    private final GeoIpLocationService locationService;

    @GetMapping("/all")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Room>> getAllRooms() {
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> createRoom(@RequestBody @Valid RoomCreateRequest request) {
        GeoIp geoCountry = locationService.getLocation(request.getIp());
        String userCountry = geoCountry.getCountry();

        Room room = new Room();

        room.setName(request.getRoomName());
        room.setCountryName(userCountry);

        return new ResponseEntity<>(roomService.save(room), HttpStatus.OK);
    }

    @GetMapping("/get")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> getIntoRoom(@RequestBody @Valid RoomGetRequest request) {
        return new ResponseEntity<>(roomService.getRoomByIp(request.getRoomName(), request.getIp()), HttpStatus.OK);
    }

    @GetMapping("/get/update")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> setLight(String roomName, String lightStatus) {
        Room room = roomService.findByName(roomName);

        room.setLightStatus(lightStatus);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }
}
