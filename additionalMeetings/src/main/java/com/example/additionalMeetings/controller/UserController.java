package com.example.additionalMeetings.controller;

import com.example.additionalMeetings.model.request.UserRequest;
import com.example.additionalMeetings.model.response.UserResponse;
import com.example.additionalMeetings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @GetMapping("/")
    public List<UserResponse> getAllUsers(){
        return userService.findAllUsers();
    }

}
