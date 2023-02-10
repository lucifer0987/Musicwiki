package com.example.musicwiki.Model;

public class TagDetailsService {

    private String image;
    private String title;
    private String artist;

    public TagDetailsService() {
    }

    public TagDetailsService(String image, String title, String artist) {
        this.image = image;
        this.title = title;
        this.artist = artist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
