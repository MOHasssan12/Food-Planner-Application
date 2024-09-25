package com.example.foodrecipesapp.Meal.Presenter;

import com.example.foodrecipesapp.Home.View.MainActivityView;
import com.example.foodrecipesapp.Meal.View.MealActivity;
import com.example.foodrecipesapp.Meal.View.MealActivityView;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

public class MealPresenter {

    private MealActivityView _view;
    private MealRepo _repo ;

    public void insertMeal(Meal meal) {
        _repo.insertMeal(meal);
        }


    public MealPresenter(MealActivityView _view, MealRepo _repo) {
        this._repo = _repo;
        this._view = _view;
    }

    public void getRandomMeal(){
       _view.showData( _repo.getStoredRandomMeal());
    }
}

