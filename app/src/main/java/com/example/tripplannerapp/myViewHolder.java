/** ===============================================================================================*/
/** FILE               : myViewHolder.java                                                         */
/** PROJECT            : Trip Planner App (Assignment 2)                                           */
/** PROGRAMMER         : Ermiyas (Endalkachew) Gulti                                               */
/** FIRST VERSION      : 2024-March-14                                                             */
/** DESCRIPTION        : This file contains the implementation of the ViewHolder used in the Trip  */
/**                   : Planner app's RecyclerView adapter.The ViewHolder holds references to the  */
/**                   : views representing individual items in the RecyclerView.                   */
/**================================================================================================*/

package com.example.tripplannerapp;

// imports
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

    /**
     * ViewHolder class for holding references to views representing individual items in the RecyclerView.
     */
    public myViewHolder(@NonNull View itemView,  RecyclerViewInterface  recyclerViewInterface){
        super(itemView);

        foodImageView = itemView.findViewById(R.id.foodImage);
        preparationTimeTextView = itemView.findViewById(R.id.preparationTime);
        foodNameTextView = itemView.findViewById(R.id.foodName);
        mealCategoriesTextView = itemView.findViewById(R.id.mealCategories);
        foodPriceTextView = itemView.findViewById(R.id.foodPrice);
        foodDescriptionTextView = itemView.findViewById(R.id.foodDescription);

        /**
         * Constructor for myViewHolder.
         *
         * @param itemView               The View object representing the layout of an individual item in the RecyclerView.
         * @param recyclerViewInterface The interface for handling RecyclerView item clicks.
         */
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
