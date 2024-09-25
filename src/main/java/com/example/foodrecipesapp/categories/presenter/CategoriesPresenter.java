package com.example.foodrecipesapp.categories.presenter;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import com.example.foodrecipesapp.AllMeals.View.AllMealsView;
import com.example.foodrecipesapp.Network.NetworkCallback;
import com.example.foodrecipesapp.Network.NetworkCallbackCat;
import com.example.foodrecipesapp.categories.View.CategoriesView;
import com.example.foodrecipesapp.model.Cateogry;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.List;

public class CategoriesPresenter implements NetworkCallbackCat {

    private CategoriesView _view;
    private MealRepo _repo ;


    public CategoriesPresenter(CategoriesView _view, MealRepo _repo) {
        this._view = _view;
        this._repo = _repo;
    }

public void getCategories(){
        _repo.listCategories(this);
}

    @SuppressLint("RestrictedApi")
    @Override
    public void onSuccessResult(List<Cateogry> cateogries) {
     _view.showData(cateogries);
        Log.i(TAG,"on showdata ");
    }

    @Override
    public void onFailureResult(String errorMsg) {
     _view.showErrMsg(errorMsg);
    }
}
