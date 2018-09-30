package com.example.mmatviyiv.labwork5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String Base_URL = "https://picsum.photos/";

    @GET("list")
    Call<List<Photo>> getPhoto();
}