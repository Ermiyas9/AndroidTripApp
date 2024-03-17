package com.example.tripplannerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activityDatabaseRecord extends AppCompatActivity {

    DatabaseHelper myDataBase;
    EditText editFirstName, editLastName, editEmail;
    Button buttonAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_record);

        // instance for our database helper class
        myDataBase = new DatabaseHelper(this);

        editFirstName = (EditText) findViewById(R.id.firstName);
        editLastName = (EditText) findViewById(R.id.lastName);
        buttonAddData = (Button) findViewById(R.id.addButton);
        AddData();
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




}
