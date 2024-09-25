package com.example.foodrecipesapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodrecipesapp.model.Meal;

import java.util.List;


@Dao
public interface MealDAO {

    @Query("SELECT * FROM meals_table")
    LiveData<List<Meal>> getPojos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);


}
