package com.example.foodrecipesapp.Network;

import com.example.foodrecipesapp.model.Cateogry;
import com.example.foodrecipesapp.model.Country;

import java.util.List;

public interface NetworkCallbackCoun {


    public void onSuccessResult(List<Country> countries);
    public void onFailureResult(String errorMsg);

}
