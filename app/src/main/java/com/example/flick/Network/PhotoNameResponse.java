package com.example.flick.Network;

import com.google.gson.annotations.SerializedName;

public class PhotoNameResponse {
    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
