package com.test.java.service.impl;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.test.java.domain.GeoIp;
import com.test.java.exception.GeoIpException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

@Service
public class GeoIpLocationService {

    public DatabaseReader RawDBGeoIPLocationService() {
        try {
            InputStream database = getClass()
                    .getClassLoader().getResourceAsStream("GeoLite2-Country.mmdb");

            return new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            throw new GeoIpException(GeoIp.class, "Ip DB problem");
        }
    }

    public GeoIp getLocation(String ip) {
        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            CountryResponse response = RawDBGeoIPLocationService().country(ipAddress);

            String countryName = response.getCountry().getName();
            return new GeoIp(ip, countryName);
        } catch (GeoIp2Exception | IOException e) {
            throw new GeoIpException(GeoIp.class, ip);
        }
    }
}


