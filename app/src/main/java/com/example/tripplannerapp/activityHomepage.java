/** ================================================================================================*/
/** FILE				: activityHomepage.java													    */
/** PROJECT            : Trip Planner App (Assignment 2)                                            */
/** PROGRAMMER			: Ermiyas (Endalkachew) Gulti											    */
/** FIRST VERSION		: 2024-02-14	                     								        */
/** DESCRIPTION			: activityHomepage.java is a class that represents the homepage             */
/**						: activity in the Trip Planner app. It initializes the UI layout		    */
/**						: and handles button clicks to navigate users to the second screen  	    */
/**						: of the app. The class uses intents to start the corresponding activities 	*/
/**=================================================================================================**/

// App package name
package com.example.tripplannerapp;

// Imports
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class activityHomepage extends AppCompatActivity {
    private static final String TAG = activityHomepage.class.getSimpleName();
    Button longClickButton1 = null;
    Button longClickButton2 = null;

    /**
     * The onCreate method is called when the activity is first created. It initializes the
     * activity's UI layout, finds the buttons by their unique IDs and sets click listeners
     * for the buttons to navigate to the second screen.
     *
     * @Parameter :- savedInstanceState a Bundle containing the activity's previously saved state,
     *                             or null if there is no saved state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        Log.d(TAG, getString(R.string.in_oncreate));

        // find the buttons by their unique id
        longClickButton1 = findViewById(R.id.home_page_button1);
        longClickButton2 = findViewById(R.id.home_page_button2);

        // Set onClickListener for both buttons to go to the nxt screen
        longClickButton1.setOnClickListener(this::navigateToSecondPage1);
        longClickButton2.setOnClickListener(this::navigateToSecondPage2);
    }


    /**
     * navigateToSecondPage1 method is called when longClickButton1 is clicked.
     * It creates an Intent to start the activitySecondPage.We have 2 buttons
     * in this class and both of them direct user in to the same screen
     *
     * @param view the View that was clicked.
     */
    public void navigateToSecondPage1(View view) {
        Intent intent;
               intent = new Intent(this, activitySecondPage.class);
        startActivity(intent);
    }


    /**
     * navigateToSecondPage2 method is called when longClickButton2 is clicked.
     * It creates an Intent to start the activitySecondPage.
     *
     * @param view the View that was clicked.
     */
    public void navigateToSecondPage2(View view) {
        Intent intent;
        intent = new Intent(this, activitySecondPage.class);
        startActivity(intent);
    }
}
