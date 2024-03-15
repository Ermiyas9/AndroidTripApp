package com.example.tripplannerapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class foodMenuRecycleView extends AppCompatActivity {

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.food_menu));

        RecyclerView recyclerView = findViewById(R.id.foodItemLists);

        List<Items> itemsList = new ArrayList<>();

        itemsList.add(new Items("Kitfo","Lunch",25.00,"\n" +
                getString(R.string.Kitfo),R.drawable.kitfo_image, 16.00));

        itemsList.add(new Items("Pakora","Dinner",18.00,"\n" + getString(R.string.pakoraDescription)
                ,R.drawable.indian_food, 18.00));

        itemsList.add(new Items("Sushi","Lunch",28.00,"\n" + getString(R.string.sushiDescription)
                ,R.drawable.japanese_food, 23.00));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new myAdapter(this,itemsList));

    }
}
