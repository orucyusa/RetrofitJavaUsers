package com.yusaoruc.UsersRetrofit.service;

import com.yusaoruc.UsersRetrofit.model.UsersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersAPI {
    @GET("users")
    Call<List<UsersModel>> getData();
}
