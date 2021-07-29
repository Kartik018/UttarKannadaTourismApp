package com.example.tourismapp.ui.datamodel;

import java.io.Serializable;

public class alldatamodel implements Serializable {
   String desc,head,image;


    public alldatamodel() {
    }

    public alldatamodel(String desc, String head, String image) {
        this.desc = desc;
        this.head = head;
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
