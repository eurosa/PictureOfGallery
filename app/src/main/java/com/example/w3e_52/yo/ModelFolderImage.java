package com.example.w3e_52.yo;

/**
 * Created by w3e-52 on 4/5/16.
 */
public class ModelFolderImage {
    String imageName;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    String fname;


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    String size;
    public ModelFolderImage(String imageName, String imageUrl,String size) {
        this.imageName = imageName;
        this.fname = imageUrl;
        this.size=size;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }




}
