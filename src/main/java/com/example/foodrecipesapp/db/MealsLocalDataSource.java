package com.example.foodrecipesapp.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.foodrecipesapp.Home.View.InsperationMeal;
import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public class MealsLocalDataSource {

    private MealDAO dao ;
    private static MealsLocalDataSource localDataSource = null ;
    private LiveData<List<Meal>> favMeals;

    private MealsLocalDataSource(Context context){
        AppDataBase db = AppDataBase.getInstance(context.getApplicationContext());
        this.dao = db.getMealDAO();
        new Thread(new Runnable() {
            @Override
            public void run() {
                favMeals = dao.getPojos();
            }
        }).start();

    }

    public MealsLocalDataSource(InsperationMeal insperationMeal) {

    }


    public static MealsLocalDataSource getInstance(Context context) {
        if(localDataSource == null){
            localDataSource = new MealsLocalDataSource(context);
        }
        return localDataSource;
    }

    public static MealsLocalDataSource getInstance(InsperationMeal insperationMeal) {
        if(localDataSource == null){
            localDataSource = new MealsLocalDataSource(insperationMeal);
        }
        return localDataSource;
    }




    public void insertMeal(Meal meal){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertMeal(meal);
            }
        }).start();
    }
    public void deleteMeal(Meal meal){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteMeal(meal);
            }
        }).start();
    }

    public LiveData<List<Meal>> getAllFavMeals(){
        return favMeals;
    }
}
