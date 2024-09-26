package com.example.additionalMeetings.service;

import com.example.additionalMeetings.model.UserModel;
import com.example.additionalMeetings.model.request.UserRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class UserService {

    private HashMap<String, UserModel> users;

    @PostConstruct
    public void init() {
        users = new HashMap<>();
    }

    public String addUser(UserRequest userRequest){
        UserModel userModel = new UserModel();

        userModel.setUserRole(userRequest.getUserRole());
        userModel.setEmail(userRequest.getEmail());
        userModel.setName(userRequest.getName());
        userModel.setNumber(userRequest.getNumber());
        userModel.setId(userRequest.getId());
        userModel.setCreationDate(LocalDate.now());

        users.put(userModel.getId(), userModel);
        return "user created";
    }
}
