package com.test.java.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_room")
@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"id"})
@ToString
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "light")
    private String lightStatus;
}
