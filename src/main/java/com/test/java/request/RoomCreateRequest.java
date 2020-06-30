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
    @Pattern(regexp = "[A-Za-z]+")
    private String countryName;
}
