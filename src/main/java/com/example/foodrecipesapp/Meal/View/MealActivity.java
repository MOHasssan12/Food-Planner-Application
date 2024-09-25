package com.example.foodrecipesapp.Meal.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.foodrecipesapp.Meal.Presenter.MealPresenter;
import com.example.foodrecipesapp.Network.MealsRemoteDataSource;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.db.AppDataBase;
import com.example.foodrecipesapp.db.MealDAO;
import com.example.foodrecipesapp.db.MealsLocalDataSource;
import com.example.foodrecipesapp.model.Meal;
import com.example.foodrecipesapp.model.MealRepo;

import java.util.List;

public class MealActivity extends AppCompatActivity implements MealActivityView {

    private MealPresenter presenter;
    private TextView txtTitle, txtCategory, txtCountry, txtInstructions;
    private TextView editName, editCate, editCountry, editInstruction;
    private ImageView mealImage;
    private Button btnAdd;
    private Meal insertedmeal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mealdetails);


        txtTitle = findViewById(R.id.txtTilte);
        txtCategory = findViewById(R.id.txtCategory);
        txtCountry = findViewById(R.id.txtCountry);
        txtInstructions = findViewById(R.id.txtInstructions);
        editName = findViewById(R.id.editName);
        editCate = findViewById(R.id.editCate);
        editCountry = findViewById(R.id.editCountry);
        editInstruction = findViewById(R.id.editInstruction);
        btnAdd = findViewById(R.id.btnAdd);

        mealImage = findViewById(R.id.mealimage);

        AppDataBase appDataBase = AppDataBase.getInstance(this);
        MealDAO mealDAO = appDataBase.getMealDAO();

        presenter = new MealPresenter(this, MealRepo.getInstance(MealsRemoteDataSource.getInstance(), MealsLocalDataSource.getInstance(this)));
        presenter.getRandomMeal();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mealdetails), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    presenter.insertMeal(insertedmeal);
                    Toast.makeText(MealActivity.this, " meal addad", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void showData(Meal meal) {
          insertedmeal = meal ;
            editName.setText(meal.getStrMeal());
            editCate.setText(meal.getStrCategory());
            editCountry.setText(meal.getStrArea());
            editInstruction.setText(meal.getStrInstructions());
            Glide.with(this)
                    .load(meal.getStrMealThumb())
                    .into(mealImage);

    }
    @Override
    public void showErrMsg(String error) {
    }
}
