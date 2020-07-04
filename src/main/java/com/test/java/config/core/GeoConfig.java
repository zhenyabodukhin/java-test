package com.test.java.config.core;

import com.maxmind.geoip2.DatabaseReader;
import com.test.java.domain.GeoIp;
import com.test.java.exception.GeoIpException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.io.IOException;

@Configuration
public class GeoConfig {

    @Bean(value = "databaseReader", destroyMethod = "close")
    @Scope("singleton")
    public DatabaseReader RawDBGeoIPLocationService() {
        try {
            File database = new File("src/main/resources/GeoLite2-Country.mmdb");
            return new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            throw new GeoIpException(GeoIp.class, "Ip DB problem");
        }
    }
}
