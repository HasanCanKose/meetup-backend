package com.springboot.meetup.repository;


import com.springboot.meetup.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    public List<Event> findByUserId(int userId);

}
