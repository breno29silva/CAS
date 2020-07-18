package com.example.cervejas.model;

import java.io.Serializable;

public class Beer implements Serializable {


    private String name;
    private String tagline;
    private String description;
    private String image_url;

    public Beer(String name, String tagline, String description, String url) {
        this.name = name;
        this.tagline = tagline;
        this.description = description;
        this.image_url = url;
    }

    public String getName() {
        return name;
    }

    public String getTagline() {
        return tagline;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_url() {
        return image_url;
    }
}
