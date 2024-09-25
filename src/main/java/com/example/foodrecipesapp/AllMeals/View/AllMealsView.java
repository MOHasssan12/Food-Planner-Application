package com.example.foodrecipesapp.AllMeals.View;

import java.util.List;

import com.example.foodrecipesapp.model.Meal;

public interface AllMealsView {

    public void showData(List<Meal> meals);
    public void showErrMsg(String error);
}
