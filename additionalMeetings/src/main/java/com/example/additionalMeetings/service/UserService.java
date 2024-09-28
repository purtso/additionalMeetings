package com.example.additionalMeetings.service;

import com.example.additionalMeetings.model.entity.UserModel;
import com.example.additionalMeetings.model.enums.UserRole;
import com.example.additionalMeetings.model.request.UserRequest;
import com.example.additionalMeetings.model.response.UserResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    private HashMap<String, UserModel> users;

    @PostConstruct
    public void init() {
        users = new HashMap<>();

        UserModel userModel = new UserModel();
        userModel.setId("001");
        userModel.setNumber("023");
        userModel.setUserRole(UserRole.LISTENER);
        userModel.setEmail("231@");
        userModel.setCreationDate(LocalDate.now());
        userModel.setName("john");
        users.put(userModel.getId(), userModel);
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

    public UserModel getUserById(String id){
        return users.get(id);
    }

    public List<UserResponse> findAllUsers() {
        Collection<UserModel> values = users.values();
        List<UserResponse> userResponses = new ArrayList<>();
        for (UserModel userModel : values) {
            userResponses.add(mapToResponse(userModel));
        }
        return userResponses;
    }

    private UserResponse mapToResponse(UserModel userModel) {
        UserResponse userResponse = new UserResponse();
        userResponse.setCreationDate(userModel.getCreationDate());
        userResponse.setEmail(userModel.getEmail());
        userResponse.setId(userModel.getId());
        userResponse.setNumber(userModel.getNumber());
        userResponse.setName(userModel.getName());
        userResponse.setUserRole(userModel.getUserRole());
        return userResponse;
    }
}
