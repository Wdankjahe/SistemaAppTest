package com.example.sistemaapptest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Meals {

    @SerializedName("meals")
    @Expose
    private ArrayList<Meal> mealId;

    public Meals(ArrayList<Meal> mealId) {
        this.mealId = mealId;
    }

    public ArrayList<Meal> getMealId() {
        return mealId;
    }
}
