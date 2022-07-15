package com.example.sistemaapptest;

public class Meal {

    private String mealId;
    private String mealName;
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
