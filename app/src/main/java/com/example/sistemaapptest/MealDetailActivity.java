package com.example.sistemaapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);
        APIList apis = RetrofitClient.getRetrofitClient().create(APIList.class);
        Intent intent = getIntent();
        Call<Meals> call = apis.getMealByID(intent.getStringExtra("mealId"));
        Log.e("MyLog", "Test");
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {

                if(response.isSuccessful()) {
                    Meals data = response.body();
                    ArrayList<Meal> meal = data.getMealId();
                    Log.e("MyLog", meal.get(0).getMealName());


                }

            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                Log.e("MyLog", t.getCause().getMessage());
                Toast.makeText(getApplicationContext(),"Something wrong. Please try again later.",Toast.LENGTH_SHORT).show();
            }
        });


    }
}