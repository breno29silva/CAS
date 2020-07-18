package com.example.cervejas.model;

import java.io.Serializable;

public class Beer implements Serializable {

    private String title;
    private String subTitle;
    private String description;
    private String url_image;

    public Beer(String title, String subTitle, String description, String url) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.url_image = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl_image() {
        return url_image;
    }
}
