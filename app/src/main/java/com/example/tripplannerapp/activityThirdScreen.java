/** ================================================================================================*/
/** FILE				:activityThirdScreen.java													*/
/** PROJECT				: Assignment 1                                                              */
/** PROGRAMMER			: Ermiyas (Endalkachew) Gulti											    */
/** FIRST VERSION		: 2024-02-14	                     								        */
/** DESCRIPTION			: activityThirdScreen.java is a class that represents the Third Screen      */
/**						: screen activity in the Trip Planner app. It initializes the UI layout	    */
/**						: and handles button clicks to navigate users to the second screen  	    */
/**						: of the app. The class uses intents to start the corresponding activities  */
/**                     : in addition it passes data to the next activity in order to calculate     */
/**                     : the fare of the trip any related data                                     */
/**=================================================================================================*/


// App package name
package com.example.tripplannerapp;

// Imports that we need from java script library
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


// Define the activity class which represents the third screen of the app
public class activityThirdScreen extends AppCompatActivity {
    private static final String TAG = activityThirdScreen.class.getSimpleName();

    // variables for button date and so on
    Button cancel;
    Button confirm;
    double pricePerNight;
    int numberOfPersons;
    int selectedDay;
    Date checkOutDate;
    Date checkInDate;
    String destination;
    String checkOutDateString;
    Switch reviewSwitch;

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdscreen);

        // find the buttons by their id
        cancel = findViewById(R.id.cancel_button);
        confirm = findViewById(R.id.confirm_button);

        // Initialize TextViews to display info
        TextView startDateTextView = findViewById(R.id.start_date_text_view);
        TextView destinationTextView = findViewById(R.id.destination_text_view);
        TextView numberOfPersonsTextView = findViewById(R.id.numberOfPersons);
        TextView pricePerNightTextView = findViewById(R.id.price);
        TextView totalPriceTextView = findViewById(R.id.total_price);

        // Retrieve the Bundle from the Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // Extract the selected date from the Bundle
            checkInDate = (Date) extras.getSerializable("date");
            startDateTextView.setText("Start Date: " + checkInDate);
            destination = extras.getString("destination");

            Intent intent = getIntent();
            numberOfPersons = intent.getIntExtra("numberOfPersons", 1);
            pricePerNight = extras.getInt("price", 0);
            destinationTextView.setText("Destination: " + destination);
            numberOfPersonsTextView.setText("Number of Persons: " + numberOfPersons);
            pricePerNightTextView.setText("Price/Night: " + pricePerNight);
        }

        // editTextView to let user to enter their checking out  date
        EditText endDateEditText = findViewById(R.id.endDate);
        reviewSwitch = findViewById(R.id.reviewSwitch);


        // Set an OnClickListener on the confirm button
        reviewSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {

                // Get the date string from the EditText field
                checkOutDateString = endDateEditText.getText().toString();
                if (!checkOutDateString.isEmpty()) {
                    try {
                        // Parse the check-out date string into a Date format..
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        Date checkOutDate = sdf.parse(checkOutDateString);

                        // Get the current date from Date func
                        Date currentDate = new Date();

                        // Check if the entered date is in the future error:
                        //noinspection DataFlowIssue
                        if (checkOutDate.after(currentDate)) {

                            // to calculate user trip fare
                            long totalPrice = calculateTotalPrice(checkInDate, checkOutDate, numberOfPersons, pricePerNight);
                            totalPriceTextView.setText("Total Price: " + totalPrice);
                        } else {
                            Toast.makeText(this, "Please enter a date in the future", Toast.LENGTH_SHORT).show();
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Please enter valid dates in the format yyyy-MM-dd", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // edit text is null so error:
                    Toast.makeText(this, "Please enter a date", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "If you don't want to view your fare price, please use the cancel button to cancel your trip or the confirm button to confirm your trip.", Toast.LENGTH_SHORT).show();
            }
        });

        // Set an OnClickListener for the confirm button
        confirm.setOnClickListener(v -> {
            if(reviewSwitch.isChecked()) {

                // to redirect the next page
                Intent intent = new Intent(this, activityFourthScreen.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Please Make sure to check your fare before confirm.", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listener for the cancel button
        cancel.setOnClickListener(v -> {

            // if users cancel take go back to sec page or prev page
            Intent intent = new Intent(this, activitySecondPage.class);
            startActivity(intent);
        });
    }

    /**
     *  Method to calculate total price based on start date, end date, number of persons, and price per night
     * Parses the selected dropdown item representing the number of travelers into an integer value.
     * param startDate The start date of the trip.endDate (Date) obj the emd of the trip numberOfPerson
     *                  to validate or calculate
     * @param numberOfPersons The number of persons traveling.
     * param pricePerNight The price per night of accommodation.
     * return The total price of the trip.
     *`
     */
    private long calculateTotalPrice(Date startDate, Date endDate, double numberOfPersons, double pricePerNight) {
        if (startDate != null && endDate != null) {

            // Calculate the difference btwn checkin an checkout in milliseconds
            long differenceInMillis = endDate.getTime() - startDate.getTime();

            // Convert milliseconds to days
            long daysStayed = differenceInMillis / (1000 * 60 * 60 * 24);

            // Calculate total price
            return (long) (pricePerNight * numberOfPersons * daysStayed);
        } else {

            return 0;
        }
    }
}