package com.example.foodrecipesapp.MealsByCate.View;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodrecipesapp.Meal.View.MealActivity;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealsByCateAdapter extends RecyclerView.Adapter<MealsByCateAdapter.ViewHolder> {

    private final Context context;
    private List<Meal> values;
    private static final String TAG = "RecyclerView";

    public MealsByCateAdapter(Context context, List<Meal> values) {
        this.context = context;
        this.values = (values != null) ? values : new ArrayList<>();
    }

    public void setList(List<Meal> values) {
        this.values = values;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView editCountrymeal;
        public TextView editCateg;
        public TextView txtcateg;
        public TextView txtTiltemeal;
        public TextView Country;
        public ImageView imageViewmeal;
        public Button btnShow;
        public ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            editCountrymeal = itemView.findViewById(R.id.editCountrymeal);
            editCateg = itemView.findViewById(R.id.editCateg);
            txtcateg = itemView.findViewById(R.id.txtcateg);
            txtTiltemeal = itemView.findViewById(R.id.txtTiltemeal);
            Country = itemView.findViewById(R.id.Country);
            imageViewmeal = itemView.findViewById(R.id.imageViewmeal);
            btnShow = itemView.findViewById(R.id.btnShow);
            constraintLayout = itemView.findViewById(R.id.allmeals);
        }
    }

    @NonNull
    @Override
    public MealsByCateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.allmeals_items, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        Log.i(TAG, "onCreateViewHolder");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealsByCateAdapter.ViewHolder holder, int position) {
        Meal meal = values.get(position);
        holder.txtTiltemeal.setText(meal.getStrMeal());
        holder.editCateg.setText(meal.getStrCategory());
        holder.Country.setText(meal.getStrArea());
        holder.txtcateg.setText(meal.getStrInstructions());

        Glide.with(context)
                .load(meal.getStrMealThumb())
                .apply(new RequestOptions()
                        .override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.imageViewmeal);

        holder.btnShow.setOnClickListener(v -> {
            Intent outIntent = new Intent(context, MealActivity.class);
            context.startActivity(outIntent);
            Log.i(TAG, "Show details for meal: " + meal.getStrMeal());
        });

        Log.i(TAG, "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return (values != null) ? values.size() : 0;
    }
}
