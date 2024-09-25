package com.example.foodrecipesapp.categories.View;

import com.example.foodrecipesapp.model.Cateogry;
import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public interface CategoriesView {

    public void showData(List<Cateogry> cateogries);
    public void showErrMsg(String error);

}
