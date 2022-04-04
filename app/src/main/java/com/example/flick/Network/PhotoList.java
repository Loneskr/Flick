package com.example.flick.Network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoList {
    @SerializedName("photo")
    private List<PhotoNameResponse> photoNames;

    public List<PhotoNameResponse> getPhotoNames() {
        return photoNames;
    }

    public void setPhotoNames(List<PhotoNameResponse> photoNames) {
        this.photoNames = photoNames;
    }
}
