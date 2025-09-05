package com.example.historicalmap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stories")
public class Story {

    @Id
    private String id;
    private String title;
    private String description;
    private int era;
    private double latitude;
    private double longitude;

    // A no-argument constructor is often needed by frameworks like Spring Data
    public Story() {
    }

    // This is the constructor our DataSeeder needs
    public Story(String title, String description, int era, double latitude, double longitude) {
        this.title = title;
        this.description = description;
        this.era = era;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // --- Getters and Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEra() {
        return era;
    }

    public void setEra(int era) {
        this.era = era;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

