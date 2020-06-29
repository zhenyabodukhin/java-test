package com.test.java.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.test.java.domain.GeoIp;
import com.test.java.service.impl.GeoIpLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "/rest/geo")
@RequiredArgsConstructor
public class GeoIpController {

    private final GeoIpLocationService locationService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GeoIp> getAddresses() throws IOException, GeoIp2Exception {
        return new ResponseEntity<>(locationService.getLocation("93.125.107.39"), HttpStatus.OK);
    }
}
