package com.example.tripplannerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // variable for our database name
    public static  final String DATABASE_NAME = "TripPlannerApp.db";
    public static  final String TABLE_NAME = "TripPlannerTable";
    public static  final String USER_ID = "User ID Number";
    public static  final String FIRST_NAME = "First Name";
    public static  final String LAST_NAME = "Last Name";
    public static  final String EMAIL = "User Email Address";
    public static  final String TRAVEL_DESTINATION = "Travel Destination";
    public static  final String TRAVEL_EXPENSE = "Travel Expense";
    public static  final String MEAL_COST= "Meal Cost";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table" + TABLE_NAME+"(USER_ID PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT, LAST_NAME TEXT, EMAIL TEXT, TRAVEL_DESTINATION TEXT, TRAVEL_EXPENSE double, MEAL_COST double)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS" + TABLE_NAME));

    }
}
