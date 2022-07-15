package com.example.sistemaapptest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL ="https://www.themealdb.com";

    public static Retrofit getRetrofitClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL)./*client(client).*/
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
        return retrofit;
    }



}
