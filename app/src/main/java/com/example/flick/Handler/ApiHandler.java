package com.example.flick.Handler;

import com.example.flick.Network.IApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {
    private static ApiHandler mInstance;

    private static final String BASE_URL = "https://api.flickr.com/services/rest/";

    private Retrofit retrofit;

    public ApiHandler(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(interceptor);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(builder.build()).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static ApiHandler getInstance() {
        if(mInstance == null) {
            mInstance = new ApiHandler();
        }
        return mInstance;
    }

    public IApiService getService() {
        return retrofit.create(IApiService.class);
    }
}
