package com.example.foodrecipesapp.MealsByCate.View;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipesapp.MealsByCate.Presenter.MealsByCatePresenter;
import com.example.foodrecipesapp.Network.MealsRemoteDataSource;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.categories.View.CategoriesAdapter;
import com.example.foodrecipesapp.categories.presenter.CategoriesPresenter;
import com.example.foodrecipesapp.db.AppDataBase;
import com.example.foodrecipesapp.db.MealDAO;
import com.example.foodrecipesapp.db.MealsLocalDataSource;
import com.example.foodrecipesapp.model.Cateogry;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.ArrayList;
import java.util.List;

public class MealsByCateActivity extends AppCompatActivity implements MealsByCateActivityView {



    private RecyclerView recyclerView;
    private MealsByCateAdapter adapter;
    private MealsByCatePresenter presenter;
    List<Cateogry> cateogries =  new ArrayList<>() ;
    MealsRemoteDataSource mealClient ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.allmeals);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("categoryName");

        AppDataBase appDataBase = AppDataBase.getInstance(this);
        MealDAO mealDAO =appDataBase.getMealDAO();

        recyclerView = findViewById(R.id.recyclerViewallmeals);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mgr = new LinearLayoutManager(getApplicationContext());
        mgr.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(mgr);
        presenter = new MealsByCatePresenter( this, MealRepo.getInstance(MealsRemoteDataSource.getInstance(), MealsLocalDataSource.getInstance(this)));
        adapter = new MealsByCateAdapter(this, new ArrayList<>() );
        recyclerView.setAdapter(adapter);
        presenter.getMealsByCate(categoryName);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.allmeals), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    @Override
    public void showData(List<Meal> meals) {
        adapter.setList(meals);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrMsg(String error) {

    }
}
