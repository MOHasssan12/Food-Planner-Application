package com.example.foodrecipesapp.Network;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.foodrecipesapp.model.MealRepo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealsRemoteDataSource {

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static MealsRemoteDataSource client = null;
    private RemoteDataService remoteDataService;


    public void getRandomMeal(NetworkCallback networkCallback) {
        Call<MealRepo> call = remoteDataService.getRandomMeal();
        call.enqueue(new Callback<MealRepo>() {
            @Override
            public void onResponse(Call<MealRepo> call, Response<MealRepo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallback.onSuccessResult(response.body().getPojos());
                } else {
                    networkCallback.onFailureResult("Meal not found");
                }
            }

            @Override
            public void onFailure(Call<MealRepo> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }



    private MealsRemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build();
        remoteDataService = retrofit.create(RemoteDataService.class);
    }

    public static MealsRemoteDataSource getInstance() {
        if (client == null) {
            client = new MealsRemoteDataSource();
        }
        return client;
    }

    public void makeNetworkCall(NetworkCallback networkCallback) {
        Call<MealRepo> call = remoteDataService.getPojos();
        call.enqueue(new Callback<MealRepo>() {
            @Override
            public void onResponse(Call<MealRepo> call, Response<MealRepo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallback.onSuccessResult(response.body().getPojos());
                } else {
                    networkCallback.onFailureResult("No meals found");
                }
            }

            @Override
            public void onFailure(Call<MealRepo> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }


    public void filterByCategory(String category, NetworkCallback networkCallback) {
        Call<MealRepo> call = remoteDataService.filterByCategory(category);
        call.enqueue(new Callback<MealRepo>() {
            @Override
            public void onResponse(Call<MealRepo> call, Response<MealRepo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallback.onSuccessResult(response.body().getPojos());
                } else {
                    networkCallback.onFailureResult("No meals found ");
                }
            }

            @Override
            public void onFailure(Call<MealRepo> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }

    public void listCategories(NetworkCallbackCat networkCallbackCat) {
        Call<MealRepo> call = remoteDataService.listCategories();
        call.enqueue(new Callback<MealRepo>() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onResponse(Call<MealRepo> call, Response<MealRepo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "Response: " + response.body().toString());
                    networkCallbackCat.onSuccessResult(response.body().getCateogries());
                    Log.i(TAG,"on showdata ");
                } else {
                    networkCallbackCat.onFailureResult("No categories found");
                }
            }

            @Override
            public void onFailure(Call<MealRepo> call, Throwable throwable) {
                networkCallbackCat.onFailureResult(throwable.getMessage());
            }
        });
    }

    public void listAreas(NetworkCallbackCoun networkCallback) {
        Call<MealRepo> call = remoteDataService.listAreas();
        call.enqueue(new Callback<MealRepo>() {
            @Override
            public void onResponse(Call<MealRepo> call, Response<MealRepo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallback.onSuccessResult(response.body().getCountries());
                } else {
                    networkCallback.onFailureResult("No areas found");
                }
            }

            @Override
            public void onFailure(Call<MealRepo> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }

}
