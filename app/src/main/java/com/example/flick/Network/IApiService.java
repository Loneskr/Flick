package com.example.flick.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiService {
    @GET("?method=flickr.photos.getRecent&api_key=24d959e5d0072975eb57cc01a69dfb5b&format=json&nojsoncallback=1")
    Call<MainResponse> getPhotos();
}
