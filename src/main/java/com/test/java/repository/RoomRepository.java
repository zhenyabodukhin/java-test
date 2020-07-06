package com.test.java.repository;

import com.test.java.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select u from Room u where u.name = :name")
    Room findByName(@Param("name") String name);
}
