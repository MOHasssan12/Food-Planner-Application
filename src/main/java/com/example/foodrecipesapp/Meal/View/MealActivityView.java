package com.example.foodrecipesapp.Meal.View;

import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public interface MealActivityView {

    public void showData(Meal meals);
    public void showErrMsg(String error);


}
