package com.example.cervejas.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.io.Serializable;

@Table
public class Beer extends SugarRecord implements Serializable {

    private String name;
    private String tagline;
    private String description;
    private String image_url;
    private Boolean isFavorite;

    public Beer() {}

    public Beer(String name, String tagline, String description, String url) {
        this.name = name;
        this.tagline = tagline;
        this.description = description;
        this.image_url = url;
        this.isFavorite = false;
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


    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }
}
