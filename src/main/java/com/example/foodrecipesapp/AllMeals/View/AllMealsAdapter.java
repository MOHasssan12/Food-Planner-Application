package com.example.foodrecipesapp.AllMeals.View;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.model.Meal;

import java.util.List;

//public class AllMealsAdapter extends  RecyclerView.Adapter<AllMealsAdapter.ViewHolder> {
//

//    private final Context context ;
//    private List<Meal> values;
//    private static final String TAG = "RecyclerView";
//    private OnMealClickListener listener;
//
//
//    public AllMealsAdapter(Context context, List<Meal> values ,OnMealClickListener _listener ) {
//        this.context = context;
//        this.values = values;
//        this.listener = _listener;
//    }
//
//
//    public void setList(List<Meal> values){
//        this.values = values;
//    }
//
//
//    public  class ViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView txtTitle;
//        public TextView txtPrice;
//        public TextView txtBrand;
//        public Button btnAdd;
//        public ConstraintLayout constraintLayout;
//        public View layout;
//        public ImageView imageView2;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            layout = itemView ;
//            txtTitle = itemView.findViewById(R.id.txtTitle);
//            txtPrice = itemView.findViewById(R.id.txtPrice);
//            txtBrand = itemView.findViewById(R.id.txtBrand);
//            btnAdd = itemView.findViewById(R.id.btnAdd);
//            imageView2 = itemView.findViewById(R.id.imageView2);
//            constraintLayout = itemView.findViewById(R.id.allproduct_layout);
//        }
//    }
//
//
//    @NonNull
//    @Override
//    public AllMealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
//        View itemView = inflater.inflate( R.layout.allproduct_layout,recyclerView , false);
//        ViewHolder vh = new ViewHolder(itemView);
//        Log.i(TAG,"onCreateViewHolder");
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AllMealsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.txtTitle.setText(values.get(position).getStrMeal());
//        holder.txtPrice.setText(values.get(position).getStrArea());
//        holder.txtBrand.setText(values.get(position).getStrCategory());
//
//        Glide.with(context)
//                .load(values.get(position).getStrMealThumb())
//                .apply(new RequestOptions()
//                        .override(200, 200)
//                        .placeholder(R.drawable.ic_launcher_background)
//                        .error(R.drawable.ic_launcher_foreground))
//                .into(holder.imageView2); // Use holder.imageView instead of holder.itemView
//        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onAddProductClick(values.get(position));
//            }
//        });
//
//        Log.i(TAG,"onbindViewHolder");
//    }
//    @Override
//    public int getItemCount() {
//        return values.size();
//    }
//
//
//}
