/** ================================================================================================*/
/** FILE				: activityFourthScreen.java													*/
/** PROJECT				: Assignment 1                                                              */
/** PROGRAMMER			: Ermiyas (Endalkachew) Gulti											    */
/** FIRST VERSION		: 2024-02-14	                     								        */
/** DESCRIPTION			: activitySecondPage.java is a class that represents the the second         */
/**						: screen activity in the Trip Planner app. It initializes the UI layout	    */
/**						: and handles button clicks to navigate users to the second screen  	    */
/**						: of the app. The class uses intents to start the corresponding activities  */
/**                     : in addition it passes data to the next activity in order to calculate     */
/**                     : the fare of the trip any related datas                                    */
/**=================================================================================================*/


// import for the last page
package com.example.tripplannerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.content.Intent;




import androidx.appcompat.app.AppCompatActivity;


public class  activityFourthScreen extends AppCompatActivity {

    /**
     * Called when the activity is first created. Responsible for initializing the activity,
     * setting its layout, and configuring the RatingBar with properties and a listener for rating changes.
     *
     * param savedInstanceState A Bundle containing the activity's previously saved state, or null if there was none.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthscreen);

        // Initialize RatingBar
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        // Set properties programmatically
        ratingBar.setNumStars(5);
        ratingBar.setStepSize(1);

        // Set listener for rating changes
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
            if (rating < 3) {
                Toast.makeText(activityFourthScreen.this, "We're sorry to hear that you had difficulties. We'll do our best to improve your experience next time.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(activityFourthScreen.this, "Thank you for your feedback! We're glad you enjoyed your trip.", Toast.LENGTH_LONG).show();
            }
        });

        // Find the button
        Button button = findViewById(R.id.foodMenuButton);

        // Set a click listener for the button
        button.setOnClickListener(view -> {

            // Create an intent to start the desired activity
            Intent intent = new Intent(activityFourthScreen.this, foodMenuRecycleView.class);

            // Start the activity
            startActivity(intent);
        });
    }
}