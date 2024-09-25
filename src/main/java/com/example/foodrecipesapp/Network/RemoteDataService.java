package com.example.foodrecipesapp.Network;

import com.example.foodrecipesapp.model.MealRepo;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

public interface RemoteDataService {

    @GET("search.php?s")
    Call<MealRepo> getPojos();

    @GET("random.php")
    Call<MealRepo> getRandomMeal();

    @GET("filter.php")
    Call<MealRepo> filterByCategory(@Query("c") String category);

    @GET("categories.php")
    Call<MealRepo> listCategories();

    @GET("list.php?a=list")
    Call<MealRepo> listAreas();

}


