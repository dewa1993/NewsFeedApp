package com.upadhyay.newsfeedapplication.model;

public class IntroContent {

    private String description;
    private String imagePath;

    public IntroContent(String description, String imagePath) {
        this.description = description;
        this.imagePath = imagePath;
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
