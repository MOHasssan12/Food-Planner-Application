package com.example.foodrecipesapp.categories.View;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipesapp.Meal.View.MealActivity;
import com.example.foodrecipesapp.MealsByCate.View.MealsByCateActivity;
import com.example.foodrecipesapp.Network.MealsRemoteDataSource;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.categories.presenter.CategoriesPresenter;
import com.example.foodrecipesapp.db.AppDataBase;
import com.example.foodrecipesapp.db.MealDAO;
import com.example.foodrecipesapp.db.MealsLocalDataSource;
import com.example.foodrecipesapp.model.Cateogry;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity  extends AppCompatActivity implements CategoriesView ,OnCategoryClickListener {

    private RecyclerView recyclerView;
    private CategoriesAdapter adapter;
    private CategoriesPresenter presenter;
    List<Cateogry> cateogries =  new ArrayList<>() ;
    MealsRemoteDataSource mealClient ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.categorylist);

        AppDataBase appDataBase = AppDataBase.getInstance(this);
        MealDAO mealDAO =appDataBase.getMealDAO();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mgr = new LinearLayoutManager(getApplicationContext());
        mgr.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(mgr);
        presenter = new CategoriesPresenter( this, MealRepo.getInstance(MealsRemoteDataSource.getInstance(), MealsLocalDataSource.getInstance(this)));
        adapter = new CategoriesAdapter(this, new ArrayList<>() );
        recyclerView.setAdapter(adapter);
        presenter.getCategories();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void showErrMsg(String error) {
        Toast.makeText(this,"fail",Toast.LENGTH_LONG).show();
    }



    @SuppressLint("RestrictedApi")
    @Override
    public void showData(List<Cateogry> cateogries) {
        adapter.setList(cateogries);
        adapter.notifyDataSetChanged();
        Log.i(TAG,"on showdata ");

    }

    @Override
    public void onCategoryClick(Cateogry cateogry) {
        Intent outIntent = new Intent(CategoriesActivity.this, MealsByCateActivity.class);
        startActivity(outIntent);
        outIntent.putExtra("categoryName",cateogry.getStrCategory());
    }
}
