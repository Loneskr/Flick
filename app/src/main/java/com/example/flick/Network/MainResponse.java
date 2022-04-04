package com.example.flick.Network;

import com.google.gson.annotations.SerializedName;

public class MainResponse {
    @SerializedName("photos")
    private PhotoList photoList;

    public PhotoList getPhotoList() {
        return photoList;
    }

    public void setPhotoList(PhotoList photoList) {
        this.photoList = photoList;
    }
}
