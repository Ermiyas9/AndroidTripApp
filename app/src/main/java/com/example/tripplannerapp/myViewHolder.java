package com.example.tripplannerapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class myViewHolder extends RecyclerView.ViewHolder{

    ImageView foodImageView;
    TextView preparationTimeTextView;
    TextView foodNameTextView;
    TextView mealCategoriesTextView;
    TextView foodPriceTextView;
    TextView foodDescriptionTextView;

    public myViewHolder(@NonNull View itemView,  RecyclerViewInterface  recyclerViewInterface){
        super(itemView);

        foodImageView = itemView.findViewById(R.id.foodImage);
        preparationTimeTextView = itemView.findViewById(R.id.preparationTime);
        foodNameTextView = itemView.findViewById(R.id.foodName);
        mealCategoriesTextView = itemView.findViewById(R.id.mealCategories);
        foodPriceTextView = itemView.findViewById(R.id.foodPrice);
        foodDescriptionTextView = itemView.findViewById(R.id.foodDescription);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerViewInterface != null)
                {
                    int position = getBindingAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            }
        });
    }

}
