package com.example.shipra.retrofit_example5;

import com.example.shipra.retrofit_example5.retrofitApi;


public class Common {

private static final String BASE_URL="http://localhost/mobileapp/";

public static retrofitApi getAPI(){

   return RetrofitClient.getClient(BASE_URL).create(retrofitApi.class);

}

}
