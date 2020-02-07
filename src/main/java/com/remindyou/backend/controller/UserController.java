package com.remindyou.backend.controller;

import com.remindyou.backend.domain.User;
import com.remindyou.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("users")
    public User saveUser(@RequestBody User user){

        user.setUuid(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }



}
