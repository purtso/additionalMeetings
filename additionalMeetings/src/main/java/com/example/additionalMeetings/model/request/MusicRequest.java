package com.example.additionalMeetings.model.request;

import com.example.additionalMeetings.model.enums.MusicGenre;

import java.util.UUID;

public class MusicRequest {
    private String title;
    private String artist;
    private String album;
    private MusicGenre genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }
}
