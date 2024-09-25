package com.example.foodrecipesapp.Network;

import com.example.foodrecipesapp.model.Cateogry;
import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public interface NetworkCallbackCat {

    public void onSuccessResult(List<Cateogry> cateogries);
    public void onFailureResult(String errorMsg);

}
