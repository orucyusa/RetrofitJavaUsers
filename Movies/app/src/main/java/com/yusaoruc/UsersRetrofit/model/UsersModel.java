package com.yusaoruc.UsersRetrofit.model;

import com.google.gson.annotations.SerializedName;

public class UsersModel {
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("username")
    public String username;

    @SerializedName("email")
    public String email;

    @SerializedName("phone")
    public String phone;
}
