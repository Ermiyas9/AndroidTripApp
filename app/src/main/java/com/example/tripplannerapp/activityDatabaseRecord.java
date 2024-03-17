/*
 * FILE                 : activityDatabaseRecord.java
 * PROJECT              : Trip Planner App (Assignment 2)
 * PROGRAMMER           : Ermiyas (Endalkachew) Gulti
 * FIRST VERSION        : 2024-March-14
 * DESCRIPTION          : This file contains the implementation of the activity responsible for interacting with the database in the Trip Planner app.
 *                      : It allows users to add data to the database and view existing data.
 */


package com.example.tripplannerapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activityDatabaseRecord extends AppCompatActivity {

    DatabaseHelper myDataBase;
    EditText editFirstName, editLastName, editEmail;
    Button buttonAddData;
    Button viewAllDataButton;
    Button goBackFromDatabaseButton;

    // Get extras from the intent this will get us the what user entered in our app so we can add it on our database
    String destination;
    String totalPrice;
    String foodPrice;
    
    /**
     * Called when the activity is first created.
     * Initializes UI components, retrieves extras from the intent,
     * and sets up the database helper.
     * @param savedInstanceState The saved instance state Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_record);

        // Get extras from the intent
        destination = getIntent().getStringExtra("destination");
        totalPrice = getIntent().getStringExtra("totalPrice");
        foodPrice = getIntent().getStringExtra("foodPrice");

        // instance for our database helper class
        myDataBase = new DatabaseHelper(this);

        // casting the edit text view and the button
        editFirstName = (EditText) findViewById(R.id.firstName);
        editLastName = (EditText) findViewById(R.id.lastName);
        buttonAddData = (Button) findViewById(R.id.addButton);
        viewAllDataButton = (Button) findViewById(R.id.viewDatabase);
        goBackFromDatabaseButton = (Button) findViewById(R.id.goBackDatabase);
        AddData();
        viewAllData();

        goBackFromDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * Sets up the OnClickListener for the "Add Data" button.
     * Inserts the entered data into the database when clicked.
     */
    public void AddData(){
        buttonAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDataBase.insertData(
                                editFirstName.getText().toString(),
                                editLastName.getText().toString(),
                                destination,
                                totalPrice,
                                foodPrice
                        );
                        if(isInserted ==true)
                        {
                            Toast.makeText(activityDatabaseRecord.this,getString(R.string.toastInsertData),Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(activityDatabaseRecord.this,"You have not Inserted the Data",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    /**
     * Sets up the OnClickListener for the "View All Data" button.
     * Retrieves all data from the database and displays it.
     */
    public  void viewAllData() {
        viewAllDataButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Cursor result = myDataBase.getAllData();
                       if(result.getCount()==0)
                       {
                           // if there is not data or result show error msg
                           showMessage("ERROR: ", "their is no Data To be displayed ");
                           return;
                       }
                        // buffer that holds all of our data
                       StringBuffer allDataHolder = new StringBuffer();

                       while(result.moveToNext()){

                           // appending all the columns so we can display it
                           allDataHolder.append("USER_ID : "+result.getString(0)+"\n");
                           allDataHolder.append("FIRST_NAME : "+result.getString(1)+"\n");
                           allDataHolder.append("LAST_NAME : "+result.getString(2)+"\n");
                           allDataHolder.append("TRAVEL_DESTINATION : "+result.getString(3)+"\n");
                           allDataHolder.append("TRAVEL_EXPENSE : "+result.getString(4)+"\n");
                           allDataHolder.append("MEAL_COST : "+result.getString(5)+"\n\n");
                       }
                       // show all of the data
                        showMessage("Data",allDataHolder.toString());
                    }
                });
    }

    /**
     * Displays a message dialog with the specified title and message.
     * @param title The title of the message dialog
     * @param message The message to be displayed in the dialog
     */
    public void showMessage(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        View dialogView = getLayoutInflater().inflate(R.layout.custom_dialogue, null);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        // Set title and message
        TextView dialogTitle = dialogView.findViewById(R.id.dialog_title);
        TextView dialogMessage = dialogView.findViewById(R.id.dialog_message);
        dialogTitle.setText(title);
        dialogMessage.setText(message);

        // Dismiss the dialog when the Cancel button is clicked
        Button btnCancel = dialogView.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
