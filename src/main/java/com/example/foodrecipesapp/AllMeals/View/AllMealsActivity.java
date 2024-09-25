package com.example.foodrecipesapp.AllMeals.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipesapp.AllMeals.Presenter.AllMealsPresenter;
import com.example.foodrecipesapp.Network.MealsRemoteDataSource;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.db.AppDataBase;
import com.example.foodrecipesapp.db.MealDAO;
import com.example.foodrecipesapp.db.MealsLocalDataSource;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.ArrayList;
import java.util.List;

public class AllMealsActivity  extends AppCompatActivity implements AllMealsView, OnMealClickListener{
    @Override
    public void showData(List<Meal> meals) {

    }

    @Override
    public void showErrMsg(String error) {

    }

    @Override
    public void onAddProductClick(Meal meal) {

    }

//
//    private RecyclerView recyclerView;
//    private AllMealsAdapter adapter;
//    private AllMealsPresenter allpresenter;
//    //private LinearLayoutManager linearLayout;
//    List<Meal> pojos =  new ArrayList<>() ;
//    MealsRemoteDataSource mealClient ;
//    MealDAO mealDAO;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.allproducts);
//
//        AppDataBase appDataBase = AppDataBase.getInstance(this);
//        mealDAO =appDataBase.getMealDAO();
//
//        mealClient = MealsRemoteDataSource.getInstance();
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager mgr = new LinearLayoutManager(getApplicationContext());
//        mgr.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(mgr);
//        allpresenter = new AllMealsPresenter((AllMealsView) this, MealRepo.getInstance(MealsRemoteDataSource.getInstance(), MealsLocalDataSource.getInstance(this)));
//        adapter = new AllMealsAdapter(this, new ArrayList<>(),this );
//        recyclerView.setAdapter(adapter);
//        allpresenter.getMeals();
//
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//
//
//
//    @Override
//    public void showData(List<Meal> meals) {
//        Toast.makeText(this,"correct",Toast.LENGTH_LONG).show();
//        adapter.setList(meals);
//        adapter.notifyDataSetChanged();
//    }
//
//    @Override
//    public void showErrMsg(String error) {
//        Toast.makeText(this,"fail",Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onAddProductClick(Meal meal) {
//        allpresenter.addToFav(meal);
//        Toast.makeText(this,"Meal Added",Toast.LENGTH_LONG).show();
//
//    }
}
