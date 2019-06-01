package com.upadhyay.newsfeedapplication.model;

public class IntroContent {

    private int id;
    private String description;
    private String imagePath;

    public IntroContent(int id, String description, String imagePath) {
        this.id = id;
        this.description = description;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
