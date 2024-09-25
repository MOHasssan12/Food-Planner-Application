package com.example.foodrecipesapp.model;

import androidx.lifecycle.LiveData;

import com.example.foodrecipesapp.Network.MealsRemoteDataSource;
import com.example.foodrecipesapp.Network.NetworkCallback;
import com.example.foodrecipesapp.Network.NetworkCallbackCat;
import com.example.foodrecipesapp.db.MealsLocalDataSource;

import java.util.List;

public class MealRepo {

    private List<Meal> meals ;
    private List<Cateogry> categories ;
    private List<Country> countries;

    private Meal randomMeal;


    MealsRemoteDataSource remoteDataSource;
    MealsLocalDataSource localDataSource;

    public List<Cateogry> getCateogries() {
        return  categories;
    }
    public List<Country> getCountries() {
        return  countries;
    }


    private static MealRepo repo = null;
    public static MealRepo getInstance(MealsRemoteDataSource remoteDataSource,MealsLocalDataSource localDataSource){
        if(repo == null){
            repo = new MealRepo(remoteDataSource,localDataSource);
        }
        return repo;
    }

    private MealRepo(MealsRemoteDataSource remoteDataSource,MealsLocalDataSource localDataSource){
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public LiveData<List<Meal>> getFavMeals(){
        return  localDataSource.getAllFavMeals();
    }

    public void getAllMeals(NetworkCallback networkCallback){
        remoteDataSource.makeNetworkCall(networkCallback);
    }

    public void getRandomMeal(NetworkCallback networkCallback){
        remoteDataSource.getRandomMeal(networkCallback);
    }

    public void listCategories(NetworkCallbackCat networkCallback){
        remoteDataSource.listCategories(networkCallback);
    }

    public void filterByCate(String category , NetworkCallback networkCallback){
        remoteDataSource.filterByCategory(category , networkCallback);
    }


    public void insertMeal(Meal meal){
        localDataSource.insertMeal(meal);
    }

    public void deleteMeal(Meal meal){
        localDataSource.deleteMeal(meal);
    }

    public List<Meal> getPojos() {
          return  meals;
    }

    public Meal getStoredRandomMeal() {
        return randomMeal;
    }

    public void setStoredRandomMeal(Meal meal) {
        randomMeal=meal;
    }
}

