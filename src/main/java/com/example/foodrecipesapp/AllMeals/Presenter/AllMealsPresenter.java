package com.example.foodrecipesapp.AllMeals.Presenter;

import com.example.foodrecipesapp.AllMeals.View.AllMealsView;
import com.example.foodrecipesapp.Network.NetworkCallback;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.List;

public class AllMealsPresenter implements NetworkCallback {

    private AllMealsView _view;
    private MealRepo _repo ;


    public AllMealsPresenter(AllMealsView _view, MealRepo _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    public void getMeals(){
        _repo.getAllMeals(this);
    }

    public void addToFav(Meal meal){
        _repo.insertMeal(meal);
    }


    @Override
    public void onSuccessResult(List<Meal> Meal) {
        _view.showData(Meal);
    }

    @Override
    public void onFailureResult(String errorMsg) {
        _view.showErrMsg(errorMsg);

    }
}
