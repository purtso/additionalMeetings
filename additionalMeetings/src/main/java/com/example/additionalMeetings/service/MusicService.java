package com.example.additionalMeetings.service;

import com.example.additionalMeetings.model.entity.MusicModel;
import com.example.additionalMeetings.model.entity.UserModel;
import com.example.additionalMeetings.model.enums.UserRole;
import com.example.additionalMeetings.model.request.MusicRequest;
import com.example.additionalMeetings.model.response.MusicResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MusicService {
    @Autowired
    private UserService userService;

    private Map<UUID, MusicModel> musicModels;

    @PostConstruct
    public void init() {
        musicModels = new HashMap<>();
        MusicModel music1 = new MusicModel();
        music1.setId(UUID.randomUUID());
        music1.setTitle("Rap god");
        music1.setArtist("Eminem");
        music1.setAlbum("MM2");
        music1.setGenre("Rap");
        musicModels.put(music1.getId(), music1);
    }

    public String addMusic(String userId, UserRole userRole, MusicRequest musicRequest) {
        UserModel user = userService.getUserById(userId);

        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        if(!user.getUserRole().equals(userRole)) {
            throw new RuntimeException("User role is incorrect");
        }

        if (!user.getUserRole().equals(UserRole.ARTIST)) {
            throw new RuntimeException("User can not add music, not artist");
        }

        MusicModel musicModel = new MusicModel();
        musicModel.setTitle(musicRequest.getTitle());
        musicModel.setArtist(musicRequest.getArtist());
        musicModel.setAlbum(musicRequest.getAlbum());
        musicModel.setGenre(musicRequest.getGenre());
        musicModel.setId(UUID.randomUUID());
        musicModels.put(musicModel.getId(), musicModel);
        return "music added";
    }

    public List<MusicResponse> getAllMusics(){
        Collection<MusicModel> values = musicModels.values();
        List<MusicResponse> responses = new ArrayList<>();
        for (MusicModel musicModel : values) {
            responses.add(mapToResponse(musicModel));
        }
        return responses;
    }

    private MusicResponse mapToResponse(MusicModel musicModel) {
        MusicResponse musicResponse = new MusicResponse();
        musicResponse.setAlbum(musicModel.getArtist());
        musicResponse.setGenre(musicModel.getGenre());
        musicResponse.setId(musicModel.getId());
        musicResponse.setTitle(musicModel.getTitle());
        musicResponse.setArtist(musicModel.getArtist());
        return musicResponse;
    }
}
