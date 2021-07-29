package com.example.tourismapp.ui.Gallery;

import java.io.Serializable;

public class gallerydatamodel implements Serializable
{
    String image,title;

    public gallerydatamodel() {
    }

    public gallerydatamodel(String image, String title) {
        this.image = image;
        this.title = title;
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
}
