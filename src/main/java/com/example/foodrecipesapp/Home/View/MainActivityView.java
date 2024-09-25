package com.example.foodrecipesapp.Home.View;

import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public interface MainActivityView {


    public void showData(List<Meal> meals);
    public void showErrMsg(String error);

}
