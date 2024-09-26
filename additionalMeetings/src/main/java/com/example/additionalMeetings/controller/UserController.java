package com.example.additionalMeetings.controller;

import com.example.additionalMeetings.model.UserModel;
import com.example.additionalMeetings.model.request.UserRequest;
import com.example.additionalMeetings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

}
