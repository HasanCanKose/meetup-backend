package com.springboot.meetup.controller;

import com.springboot.meetup.entity.User;
import com.springboot.meetup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST, value = "/users/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping("/users/get")
    public User getUser(HttpServletRequest request) {
        return userService.getUser(request);
    }

}
