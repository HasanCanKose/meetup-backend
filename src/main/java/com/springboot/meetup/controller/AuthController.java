package com.springboot.meetup.controller;

import com.springboot.meetup.entity.AuthRequest;
import com.springboot.meetup.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username or password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());

    }
}
