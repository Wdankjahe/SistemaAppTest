package com.example.sistemaapptest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIList {


    @GET("/api/json/v1/1/filter.php?c=Seafood")
    Call<Meals> getAllMeals();

    @Headers({"Accept: application/json"})
    @GET("/api/json/v1/1/lookup.php")
    Call<Meals> getMealByID(@Query("i") String i);


}
