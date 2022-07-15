package com.example.sistemaapptest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal {
    @SerializedName("idMeal")
    @Expose
    private String mealId;
    @SerializedName("strMeal")
    @Expose
    private String mealName;
    @SerializedName("strMealThumb")
    @Expose
    private String mealImgURL;

    public Meal(String mealId, String mealName, String mealImgURL) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealImgURL = mealImgURL;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealImgURL() {
        return mealImgURL;
    }

    public void setMealImgURL(String mealImgURL) {
        this.mealImgURL = mealImgURL;
    }
}
