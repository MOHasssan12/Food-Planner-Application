package com.example.foodrecipesapp.Home.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.categories.View.CategoriesActivity;
import com.example.foodrecipesapp.model.Meal;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private Button btnCategory;


    private static final String TAG = "Home Screen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCategory = findViewById(R.id.btnCategory);
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(outIntent);
            }
        });


        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction tran = mgr.beginTransaction();
        InsperationMeal staticFrag = new InsperationMeal();
        tran.add(R.id.inspirFragmentCon, staticFrag, "StaticFragment");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void showData(List<Meal> meals) {

    }

    @Override
    public void showErrMsg(String error) {

    }
}