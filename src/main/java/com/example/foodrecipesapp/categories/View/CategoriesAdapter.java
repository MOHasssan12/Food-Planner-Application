package com.example.foodrecipesapp.categories.View;

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
import com.example.foodrecipesapp.MealsByCate.View.MealsByCateActivity;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.model.Cateogry;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends  RecyclerView.Adapter<CategoriesAdapter.ViewHolder>  {



       private final Context context ;
       private List<Cateogry> values ;
       private static final String TAG = "RecyclerView";


    public CategoriesAdapter(Context context, List<Cateogry> values) {
        this.context = context;
        this.values = (values != null) ? values : new ArrayList<>();
    }


    public void setList(List<Cateogry> values){
        this.values = values;
        notifyDataSetChanged();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtCategory;
        public TextView txtDesc;
        public TextView editCategory;
        public TextView editDesc;
        public ConstraintLayout constraintLayout;
        public View layout;
        public ImageView imageViewCat;
        public Button btnShowlist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView ;
            btnShowlist = itemView.findViewById(R.id.btnShowlist);
            txtCategory = itemView.findViewById(R.id.txtcategory);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            editCategory = itemView.findViewById(R.id.editCategory);
            editDesc = itemView.findViewById(R.id.editDesc);
            imageViewCat = itemView.findViewById(R.id.imageViewCat);
            constraintLayout = itemView.findViewById(R.id.cat_layout);
        }
    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View itemView = inflater.inflate( R.layout.category_layout,recyclerView , false);
        ViewHolder vh = new ViewHolder(itemView);
        Log.i(TAG,"onCreateViewHolder");
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        Cateogry category = values.get(position);

        holder.editDesc.setText(category.getStrCategoryDescription());
        holder.editCategory.setText(category.getStrCategory());

        Glide.with(context)
                .load(category.getStrCategoryThumb())
                .apply(new RequestOptions()
                        .override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.imageViewCat);

        holder.btnShowlist.setOnClickListener(v -> {
            Intent outIntent = new Intent(context, MealsByCateActivity.class);
            context.startActivity(outIntent);
            Log.i(TAG, "Show meals for category: " + category.getStrCategory());
        });

        Log.i(TAG, "onBindViewHolder");
    }


    @Override
    public int getItemCount() {
        return (values != null) ? values.size() : 0;
    }
}
