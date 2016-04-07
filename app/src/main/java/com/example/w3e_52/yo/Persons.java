package com.example.w3e_52.yo;

/**
 * Created by w3e-52 on 3/15/16.
 */
public class Persons {

    public String getSize() {
        return size;
    }

    String size;
    public Persons(String imageurl, String name,String thumb,String size) {
        this.imageurl = imageurl;
        this.name = name;
        this.thumb=thumb;
        this.size=size;
    }

    public Persons() {

    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String  imageurl;
    public String name;

    public String getThumb() {
        return thumb;
    }

    public String thumb;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
