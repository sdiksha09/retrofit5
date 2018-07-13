package com.example.shipra.retrofit_example5;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit=null;

    public static Retrofit getClient(String baseurl) {

        if (retrofit == null) {

        }
        return retrofit;
    }
}