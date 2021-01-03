package com.springboot.meetup.service;

import com.springboot.meetup.entity.User;
import com.springboot.meetup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        User user = userRepository.findByUserName(principal.getName());
        return user;
    }
}
