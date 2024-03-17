/** ================================================================================================*/
/** FILE               : foodMenuRecycleView.java                                                   */
/** PROJECT            : Trip Planner App (Assignment 2)                                            */
/** PROGRAMMER         : Ermiyas (Endalkachew) Gulti                                                */
/** FIRST VERSION      : 2024-March-14                                                              */
/** DESCRIPTION        : foodMenuRecycleView.java is an activity class that displays a list of food */
/**                      items using a RecyclerView. It populates the RecyclerView with a list of   */
/**                      Items objects and handles item clicks. When an item is clicked, it starts  */
/**                      the miniScreen activity and passes relevant data to it.                    */
/**=================================================================================================*/

package com.example.tripplannerapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class foodMenuRecycleView extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<Items> itemList = new ArrayList<>();

    /**
     * Initializes the RecyclerView and populates it with food items.
     *
     * @param savedInstanceState The saved instance state bundle.
     */
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.food_menu));

        RecyclerView recyclerView = findViewById(R.id.foodItemLists);

        // Set LinearLayoutManager for vertical scrolling
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList.add(new Items("Name Of the Food => Kitfo", "Meal Category => Lunch", 25.00,
                getString(R.string.Kitfo), R.drawable.kitfo_image, 16.00));

        itemList.add(new Items("Name Of the Food => Pakora", "Meal Category => Dinner", 18.00,
                getString(R.string.pakoraDescription),
                R.drawable.indian_food, 18.00));

        itemList.add(new Items("Name Of the Food => Sushi", "Meal Category: Lunch", 28.00,
                getString(R.string.sushiDescription),
                R.drawable.japanese_food, 23.00));

        itemList.add(new Items("Name Of the Food => Halloumi and Falafel", "Meal Category: Breakfast", 32.00,
                getString(R.string.arabicFoodDescription),
                R.drawable.arabicfood, 13.00));

        itemList.add(new Items("Name Of the Food => Doro Wet", "Meal Category: Dinner", 18.00,
                getString(R.string.dorowet),
                R.drawable.dorowot, 50.00));

        itemList.add(new Items("Name Of the Food => Vampiro", "Meal Category: Lunch/Breakfast", 28.00,
                getString(R.string.mexicanFoodDescription),
                R.drawable.mexicanfood, 23.00));

        itemList.add(new Items("Name Of the Food => Lasagna", "Meal Category: Breakfast", 18.00,
                getString(R.string.italianLasagnadescr) +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n",
                R.drawable.lasagna_italian, 18.00));

        itemList.add(new Items("Pasta", "Meal Category: Lunch", 28.00,
                getString(R.string.pastaDescription1),
                R.drawable.pasta_italiano, 23.00));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new myAdapter(this, itemList, this));

        int position = 2;
        recyclerView.smoothScrollToPosition(position);
    }

    /**
     * Method to handle item click events from the RecyclerView.
     *
     * @param position The position of the clicked item in the RecyclerView.
     */
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
