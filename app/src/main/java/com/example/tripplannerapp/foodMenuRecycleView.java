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
        setContentView((R.layout.foodMenu));

        RecyclerView recyclerView = findViewById(R.id.foodItemLists);

        List<Items> itemsList = new ArrayList<Items>();

        itemsList.add(new Items("Kitfo","Lunch",25.00,""));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new myAdapter(getApplicationContext(),));

    }
}
