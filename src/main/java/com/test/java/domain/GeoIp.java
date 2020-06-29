package com.test.java.domain;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GeoIp {

    private String ipAddress;

    private String country;

}
