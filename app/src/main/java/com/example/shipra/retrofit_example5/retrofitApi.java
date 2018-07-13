package com.example.shipra.retrofit_example5;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface retrofitApi {

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone")String phone,
                               @Field("name")String name,
                               @Field("email")String email);
}
