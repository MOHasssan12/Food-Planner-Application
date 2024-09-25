package com.example.foodrecipesapp.MealsByCate.View;

import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public interface MealsByCateActivityView {
    public void showData(List<Meal> meals);
    public void showErrMsg(String error);

}
