package com.example.sistemaapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    boolean called = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_listing);
        gridView = findViewById(R.id.mealgrid);


            APIList apis = RetrofitClient.getRetrofitClient().create(APIList.class);
            Call<Meals> call = apis.getAllMeals();

            call.enqueue(new Callback<Meals>() {
                @Override
                public void onResponse(Call<Meals> call, Response<Meals> response) {

                    if(response.isSuccessful()) {
                        Meals data = response.body();
                        ArrayList<Meal> meal = data.getMealId();

                        MealAdapter adapter = new MealAdapter(getApplicationContext(),0,meal);
                        gridView.setAdapter(adapter);

                    }

                }

                @Override
                public void onFailure(Call<Meals> call, Throwable t) {
                    //Log.e("MyLog", t.getCause().getMessage());
                    Toast.makeText(getApplicationContext(),"Something wrong. Please try again later.",Toast.LENGTH_SHORT).show();
                }
            });

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Meal meal = (Meal)adapterView.getItemAtPosition(i);
                    Log.e("MyLog", meal.getMealId());
                    Intent intent = new Intent(MainActivity.this,MealDetailActivity.class);
                    intent.putExtra("MealId",meal.getMealId());
                    startActivity(intent);
                }
            });



    }


}