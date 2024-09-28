package com.example.additionalMeetings.controller;

import com.example.additionalMeetings.model.enums.UserRole;
import com.example.additionalMeetings.model.request.MusicRequest;
import com.example.additionalMeetings.model.response.MusicResponse;
import com.example.additionalMeetings.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/")
    public String addMusic(@RequestParam UserRole userRole, @RequestParam String userId, @RequestBody MusicRequest musicRequest){
        return musicService.addMusic(userId,userRole,musicRequest);
    }

    @GetMapping("/")
    public List<MusicResponse> getAllMusic(){
        return musicService.getAllMusics();
    }
}
