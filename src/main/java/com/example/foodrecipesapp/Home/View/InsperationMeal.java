package com.example.foodrecipesapp.Home.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.foodrecipesapp.Home.Presenter.MainActivityPresenter;
import com.example.foodrecipesapp.Meal.View.MealActivity;
import com.example.foodrecipesapp.Network.MealsRemoteDataSource;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.categories.View.CategoriesActivity;
import com.example.foodrecipesapp.db.MealsLocalDataSource;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.List;

public class InsperationMeal extends Fragment implements MainActivityView {

    private TextView txtMealOfTheDay;
    private TextView txtStrMeal;
    private ImageView insirMeal;
    private MealsRemoteDataSource mealClient;
    private MealsLocalDataSource localDataSource;
    private MainActivityPresenter presenter;
    public InsperationMeal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MainActivityPresenter( this, MealRepo.getInstance(MealsRemoteDataSource.getInstance(), MealsLocalDataSource.getInstance(this)));
        presenter.getRandomMeal();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mealoftheday, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        txtMealOfTheDay = view.findViewById(R.id.txtMealOfTheDay);
        Button btnShow = view.findViewById(R.id.btnShowRandom);
        txtStrMeal = view.findViewById(R.id.txtStrMeal);
        insirMeal = view.findViewById(R.id.inspirMeal);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getActivity(), MealActivity.class);
                startActivity(outIntent);
            }
        });

           }

    @Override
    public void showData(List<Meal> meals) {
        if (meals != null && !meals.isEmpty()) {
            Meal meal = meals.get(0);
            txtStrMeal.setText(meal.getStrMeal());

            Glide.with(this)
                    .load(meal.getStrMealThumb())
                    .into(insirMeal);
        } else {
            txtStrMeal.setText("");
            insirMeal.setImageResource(R.drawable.ic_launcher_background);
        }

    }

    @Override
    public void showErrMsg(String error) {

    }
}

