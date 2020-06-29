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

    public DatabaseReader RawDBGeoIPLocationService() throws IOException {
        File database = new File("src/main/resources/GeoLite2-Country.mmdb");
        return new DatabaseReader.Builder(database).build();
    }

    public GeoIp getLocation(String ip)
            throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CountryResponse response = RawDBGeoIPLocationService().country(ipAddress);

        String countryName = response.getCountry().getName();
        return new GeoIp(ip, countryName);
    }
}


