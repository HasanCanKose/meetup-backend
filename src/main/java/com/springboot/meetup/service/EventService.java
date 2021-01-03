package com.springboot.meetup.service;

import com.springboot.meetup.entity.Event;
import com.springboot.meetup.entity.User;
import com.springboot.meetup.repository.EventRepository;
import com.springboot.meetup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Event> getAllEvents(){
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);
        return events;
    }

    public List<Event> getUserEvents(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        User user = userRepository.findByUserName(principal.getName());
        List<Event> events = new ArrayList<>();
        eventRepository.findByUserId(user.getId()).forEach(events::add);
        return events;
    }
}