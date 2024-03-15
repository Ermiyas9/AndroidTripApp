package com.example.tripplannerapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class miniScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.mini_screen);


        String foodName = getIntent().getStringExtra("foodName");
        String mealCategory = getIntent().getStringExtra("mealCategories");
        double foodPrice = getIntent().getDoubleExtra("foodPrice", 0.0);
        String foodDescription = getIntent().getStringExtra("foodDescription");
        int foodImage = getIntent().getIntExtra("foodImage", 0);
        double preparationTime = getIntent().getDoubleExtra("preparationTimeMinutes", 0.0); 


        ImageView foodImageView = findViewById(R.id.foodImage);
        TextView preparationTimeTextView = findViewById(R.id.preparationTime);
        TextView foodNameTextView = findViewById(R.id.foodName);
        TextView mealCategoriesTextView = findViewById(R.id.mealCategories);
        TextView foodPriceTextView = findViewById(R.id.foodPrice);
        TextView foodDescriptionTextView = findViewById(R.id.foodDescription);

        foodImageView.setImageResource(foodImage);
        preparationTimeTextView.setText(String.valueOf(preparationTime));
        foodNameTextView.setText(foodName);
        mealCategoriesTextView.setText(foodDescription);
        foodPriceTextView.setText(String.valueOf(foodPrice));
        foodDescriptionTextView.setText(foodDescription);
    }

    public void goBack(View view) {
        finish();
    }
}
