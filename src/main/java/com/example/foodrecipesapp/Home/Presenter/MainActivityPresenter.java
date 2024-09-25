package com.example.foodrecipesapp.Home.Presenter;

import com.example.foodrecipesapp.AllMeals.View.AllMealsView;
import com.example.foodrecipesapp.Home.View.MainActivityView;
import com.example.foodrecipesapp.Network.NetworkCallback;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.List;

public class MainActivityPresenter  implements NetworkCallback {


    private MainActivityView _view;
    private MealRepo _repo ;


    public void getMeals(){
        _repo.getAllMeals(this);
    }

    public void getRandomMeal(){
        _repo.getRandomMeal(this);
    }


    public MainActivityPresenter(MainActivityView _view, MealRepo _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void onSuccessResult(List<Meal> Meal) {
         _view.showData(Meal);
        Meal  randomMeal = Meal.get(0);
         _repo.setStoredRandomMeal(randomMeal);
    }

    @Override
    public void onFailureResult(String errorMsg) {

    }
}
