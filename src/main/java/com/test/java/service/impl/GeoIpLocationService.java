package com.test.java.service.impl;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.test.java.domain.GeoIp;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class GeoIpLocationService {

    public DatabaseReader RawDBGeoIPLocationService() {
        try {
            File database = new File("src/main/resources/GeoLite2-Country.mmdb");
            return new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            System.out.println("Geo database not found");
        }
        return null;
    }

    public GeoIp getLocation(String ip) {
        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            CountryResponse response = RawDBGeoIPLocationService().country(ipAddress);

            String countryName = response.getCountry().getName();
            return new GeoIp(ip, countryName);
        } catch (GeoIp2Exception | IOException e) {
            System.out.println("Problems with Geo method");
        }
        return null;
    }
}


