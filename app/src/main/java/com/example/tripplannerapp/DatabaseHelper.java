/** ================================================================================================*/
/** FILE               : DatabaseHelper.java                                                        */
/** PROJECT            : Trip Planner App (Assignment 2)                                            */
/** PROGRAMMER         : Ermiyas (Endalkachew) Gulti                                                */
/** FIRST VERSION      : 2024-March-14                                                              */
/** DESCRIPTION        : DatabaseHelper.java is a helper class for managing the SQLite database     */
/**                      used in the Trip Planner app. It handles database creation, table creation,*/
/**                      insertion of data, and retrieval of data operations.                       */
/**=================================================================================================*/


package com.example.tripplannerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // variable for our database name
    public static  final String DATABASE_NAME = "TripPlannerApp.db";
    public static  final String TABLE_NAME = "TripPlannerTable";
    public static  final String USER_ID = "User ID";
    public static  final String FIRST_NAME = "First Name";
    public static  final String LAST_NAME = "Last Name";
    //public static  final String EMAIL_ADDRESS = "Email Address";
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
        db.execSQL("CREATE TABLE" + TABLE_NAME + " (" +
                "USER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FIRST_NAME TEXT," +
                "LAST_NAME TEXT," +
                "TRAVEL_DESTINATION TEXT," +
                "TRAVEL_EXPENSE REAL," +
                "MEAL_COST REAL)");
    }

    /**
     * Called when the database needs to be upgraded. This method will drop the existing table
     * and recreate a new one. You can alter your table schema here.
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
    }

    /**
     * Inserts data into the database.
     *
     * @param firstName   The first name of the user.
     * @param lastName    The last name of the user.
     * @param destination The travel destination.
     * @param totalPrice  The total travel expense.
     * @param foodPrice   The meal cost.
     * @return true if the data is inserted successfully, otherwise false.
     */
    public boolean insertData(String firstName, String lastName, String destination, String totalPrice, String foodPrice){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRST_NAME",firstName);
        contentValues.put("LAST_NAME",lastName);
        contentValues.put("TRAVEL_DESTINATION", destination);
        contentValues.put("TRAVEL_EXPENSE", totalPrice);
        contentValues.put("MEAL_COST", foodPrice);


        long insetDetectorFlag= db.insert(TABLE_NAME,null,contentValues);

        // checking if we inserted the data or not
        if (insetDetectorFlag == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Retrieves all data from the database.
     *
     * @return A Cursor object containing all the data.
     */
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_NAME,null);

        return  result;
    }
}
