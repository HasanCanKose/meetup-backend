package com.springboot.meetup.controller;

import com.springboot.meetup.entity.Event;
import com.springboot.meetup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class EventController {

    @Autowired
    private EventService eventService;


    @RequestMapping("/events")
    public List<Event> getAllEvents(){
        return this.eventService.getAllEvents();
    }

    @RequestMapping("/events/user")
    public List<Event> getUserEvents(HttpServletRequest request){
        return this.eventService.getUserEvents(request);

    }
}
