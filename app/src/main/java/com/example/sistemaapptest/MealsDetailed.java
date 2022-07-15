package com.example.sistemaapptest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MealsDetailed {

    @SerializedName("meals")
    @Expose
    private ArrayList<MealDetail> mealId;

    public MealsDetailed(ArrayList<MealDetail> mealId) {
        this.mealId = mealId;
    }

    public ArrayList<MealDetail> getMealId() {
        return mealId;
    }
}
