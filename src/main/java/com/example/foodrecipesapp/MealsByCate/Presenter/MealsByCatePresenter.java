package com.example.foodrecipesapp.MealsByCate.Presenter;

import android.content.Intent;

import com.example.foodrecipesapp.Home.View.MainActivityView;
import com.example.foodrecipesapp.MealsByCate.View.MealsByCateActivityView;
import com.example.foodrecipesapp.Network.NetworkCallback;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.List;

public class MealsByCatePresenter implements NetworkCallback {

    private MealsByCateActivityView _view;
    private MealRepo _repo ;
    private String categoryName;

    public MealsByCatePresenter(MealsByCateActivityView _view,  MealRepo _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    public void getMealsByCate(String categoryName){
        _repo.filterByCate(categoryName , this);
    }

    @Override
    public void onSuccessResult(List<Meal> Meal) {
      _view.showData(Meal);
    }

    @Override
    public void onFailureResult(String errorMsg) {

    }
}
