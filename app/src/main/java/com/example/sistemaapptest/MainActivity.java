package com.example.sistemaapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_listing);
        gridView = findViewById(R.id.mealgrid);
        ArrayList<Meal> mealLists = new ArrayList<>();
        mealLists.add(new Meal("11111","Baked salmon with fennel & tomatoes","https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1548772327.jpg"));
        MealAdapter adapter = new MealAdapter(this,0,mealLists);
        gridView.setAdapter(adapter);

    }
}