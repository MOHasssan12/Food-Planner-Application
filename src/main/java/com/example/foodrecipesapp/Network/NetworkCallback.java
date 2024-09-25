package com.example.foodrecipesapp.Network;

import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public interface NetworkCallback {

    public void onSuccessResult(List<Meal> Meal);
    public void onFailureResult(String errorMsg);

}
