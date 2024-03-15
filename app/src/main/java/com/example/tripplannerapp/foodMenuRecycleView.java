package com.example.tripplannerapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class foodMenuRecycleView extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<Items> itemList = new ArrayList<>();
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.food_menu));

        RecyclerView recyclerView = findViewById(R.id.foodItemLists);

        // Set LinearLayoutManager for vertical scrolling
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        itemList.add(new Items("Name Of the Food: + \n Kitfo", "Meal Category: Lunch", 25.00, "\n" +
                getString(R.string.Kitfo), R.drawable.kitfo_image, 16.00));

        itemList.add(new Items("Name Of the Food: + \n Pakora", "Meal Category: Dinner", 18.00, "\n" + getString(R.string.pakoraDescription)
                , R.drawable.indian_food, 18.00));

        itemList.add(new Items("Name Of the Food: + \n Sushi", "Meal Category: Lunch", 28.00, "\n" + getString(R.string.sushiDescription)
                , R.drawable.japanese_food, 23.00));

        itemList.add(new Items("Name Of the Food: + \n Halloumi and Falafel", "Meal Category: BreakFast", 32.00, "\n" +
                "\n" +
                getString(R.string.arabicFoodDescription), R.drawable.arabicfood, 13.00));

        itemList.add(new Items("Name Of the Food: + \n Doro Wet", "Meal Category: Dinner", 18.00, "\n" + getString(R.string.dorowet)
                , R.drawable.dorowot, 50.00));

        itemList.add(new Items("Vampiro", "Lunch/Breakfast", 28.00, "\n" + getString(R.string.mexicanFoodDescription)
                , R.drawable.mexicanfood, 23.00));


        itemList.add(new Items("Lasagna", "Meal Category: BreakFast", 18.00, "\n" + getString(R.string.pakoraDescription)
                , R.drawable.lasagna_italian, 18.00));

        itemList.add(new Items("Pasta", "Meal Category: Lunch", 28.00, "\n" + getString(R.string.sushiDescription)
                , R.drawable.pasta_italiano, 23.00));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new myAdapter(this, itemList, this));

        int position = 2;
        recyclerView.smoothScrollToPosition(position);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(foodMenuRecycleView.this, miniScreen.class);

        // Retrieve the Items object from the list at the specified position
        Items clickedItem = itemList.get(position);

        // Put extra data into the intent
        intent.putExtra("foodName", clickedItem.getFoodName());
        intent.putExtra("mealCategories", clickedItem.getMealCategories());
        intent.putExtra("foodPrice", clickedItem.getFoodPrice());
        intent.putExtra("foodDescription", clickedItem.getFoodDescription());
        intent.putExtra("foodImage", clickedItem.getFoodImage());
        intent.putExtra("preparationTimeMinutes", clickedItem.getPreparationTimeMinutes());

        // Start the miniScreen activity with the intent
        startActivity(intent);
    }


}
