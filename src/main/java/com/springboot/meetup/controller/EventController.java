package com.springboot.meetup.controller;

import com.springboot.meetup.entity.Event;
import com.springboot.meetup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EventController {

    @Autowired
    private EventService eventService;


    @RequestMapping("/events")
    public List<Event> getAllEvents(){
        return this.eventService.getAllEvents();
    }
}
