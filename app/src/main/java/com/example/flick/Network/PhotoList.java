package com.example.flick.Network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoList {
    @SerializedName("photo")
    private List<PhotoName> photoNames;

    public List<PhotoName> getPhotoNames() {
        return photoNames;
    }

    public void setPhotoNames(List<PhotoName> photoNames) {
        this.photoNames = photoNames;
    }
}
