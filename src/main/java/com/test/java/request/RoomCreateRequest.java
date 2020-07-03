package com.test.java.request;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RoomCreateRequest {

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Za-z]+")
    private String roomName;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.\n" +
            "([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])$")
    private String ip;
}
