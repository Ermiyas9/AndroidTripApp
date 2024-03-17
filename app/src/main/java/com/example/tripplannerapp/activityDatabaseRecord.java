package com.example.tripplannerapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activityDatabaseRecord extends AppCompatActivity {

    DatabaseHelper myDataBase;
    EditText editFirstName, editLastName, editEmail;
    Button buttonAddData;
    Button viewAllDataButton;
    Button goBackFromDatabaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_record);

        // instance for our database helper class
        myDataBase = new DatabaseHelper(this);

        editFirstName = (EditText) findViewById(R.id.firstName);
        editLastName = (EditText) findViewById(R.id.lastName);
        buttonAddData = (Button) findViewById(R.id.addButton);
        viewAllDataButton = (Button) findViewById(R.id.viewDatabase);
        goBackFromDatabaseButton = (Button) findViewById(R.id.goBackDatabase);
        AddData();


        goBackFromDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void AddData(){
        buttonAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDataBase.insertData(editFirstName.getText().toString(),
                                editLastName.getText().toString());

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

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
    }
}
