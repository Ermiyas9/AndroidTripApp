/** ================================================================================================*/
/** FILE				: activitySecondPage.java													*/
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


// App package name
package com.example.tripplannerapp;

// Imports that we need from java script library
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;


public class activitySecondPage extends AppCompatActivity {
    private static final String TAG = activitySecondPage.class.getSimpleName();

    // various variables that we need in over of the current activity
    boolean dropDwnListSelected = false;
    int selectedRadioValue;
    CalendarView calendarView;
    boolean flagForCalendar = false;

    // Create a Bundle to store multiple values
    Bundle bundle = new Bundle();


    /**
     * The onCreate method is called when the activity is first created. It initializes the
     * activity's UI layout, finds the buttons by their unique IDs and sets click listeners
     * for the buttons to navigate to the second screen. as wee to process user interaction with
     *
     * UI that handle user interaction with the app as well  configure and validate and transfer file
     * @Parameter :- savedInstanceState a Bundle containing the activity's previously saved state,
     *                             or null if there is no saved state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        Intent intent = new Intent(activitySecondPage.this, activityThirdScreen.class);
        super.onCreate(savedInstanceState);
        Log.d(TAG, "In onCreate");

        // linking the xml the xml file with java or this class
        setContentView(R.layout.secondscreen);
        calendarView = findViewById(R.id.calendarView);
        //calandar = Calendar.getInstance();

        // Set the date change listener for the CalendarView
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                // Create a Calendar instance and set it to the selected date
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                // Get the current date
                Calendar currentCalendar = Calendar.getInstance();

                // Set the maximum selectable date to one year ahead
                Calendar maxSelectableCalendar = Calendar.getInstance();
                maxSelectableCalendar.add(Calendar.YEAR, 1);

                // Check if the selected date is within the acceptable range
                if (selectedDate.after(currentCalendar) && selectedDate.before(maxSelectableCalendar)) {

                    // Convert the Calendar instance to a Date object
                    Date date = selectedDate.getTime();

                    String dateLabel = "Day";

                    // Add the selected date and label to the Bundle
                    bundle.putSerializable("date", date);

                    // Pass the value of id number
                    intent.putExtras(bundle);

                    flagForCalendar = true;
                } else {

                    // Prompt the user to select a valid date within the acceptable range
                    Toast.makeText(activitySecondPage.this, "Please select a date from today up to one year ahead", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Initialize ImageView variables in the onCreate method
        RadioButton RadioBtnTokyo = findViewById(R.id.RadioBtnTokyo);
        RadioButton RadioBtnNewYork = findViewById(R.id.RadioBtnNewYork);
        RadioButton RadioBtnEngland = findViewById(R.id.RadioBtnEngland);

        // Find the dropdown view
        Spinner dropdown = findViewById(R.id.list);

        // Create an ArrayAdapter using the string array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.list, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (dropdown != null) {
            dropDwnListSelected = true;
            dropdown.setAdapter(adapter);

            // Set a listener to handle the selection
            dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedValue = parent.getItemAtPosition(position).toString();
                    int numberOfPersons = parseDropdownItem(selectedValue);

                    intent.putExtra("numberOfPersons", numberOfPersons);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(activitySecondPage.this, "Please choose one of the options from the dropdown list", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.e(TAG, "Dropdown view (Spinner) not found in the layout.");
        }

        // Set click listeners for each radio button
        RadioBtnEngland.setOnClickListener(v -> {
            // Uncheck other radio buttons when user check this btn
            RadioBtnTokyo.setChecked(false);
            RadioBtnNewYork.setChecked(false);


            // If checked, set the value of id number
            selectedRadioValue = 150;
            // Add values to the Bundle
            bundle.putInt("price", selectedRadioValue);
            bundle.putString("destination", "Manchester England");

            // Pass the value of id number
            intent.putExtras(bundle);
        });

        RadioBtnTokyo.setOnClickListener(v -> {
            // Uncheck other radio buttons
            RadioBtnEngland.setChecked(false);
            RadioBtnNewYork.setChecked(false);

            // If checked, set the value of id number
            selectedRadioValue = 140;
            // Add values to the Bundle
            bundle.putInt("price", selectedRadioValue);
            bundle.putString("destination", "Japan Tokyo");
            // to send data to the next screen

            // Pass the value of id number
            intent.putExtras(bundle);
        });
        RadioBtnNewYork.setOnClickListener(v -> {
            // Uncheck other radio buttons
            RadioBtnEngland.setChecked(false);
            RadioBtnTokyo.setChecked(false);

            // If checked, set the value of id number
            selectedRadioValue = 160;
            // Add values to the Bundle
            bundle.putInt("price", selectedRadioValue);
            bundle.putString("destination", "New York City");
            // to send data to the next screen

            // Pass the value of id number
            intent.putExtras(bundle);
        });

        // find the next and prev button by their ID then we can give them action to do
        Button nextButton = findViewById(R.id.explore_next_button2);

        // Set click listener for the Next button
        nextButton.setOnClickListener(v -> {
            if ((RadioBtnEngland.isChecked() || RadioBtnTokyo.isChecked() || RadioBtnNewYork.isChecked()) && flagForCalendar && dropDwnListSelected) {
                // start the intent
                startActivity(intent);
            } else {
                // Prompt the user to provide at least one input for pictures, dropdown, or date
                Toast.makeText(activitySecondPage.this, "Please select at least one input for pictures, dropdown, and your trip start date from current date up to a year from now.", Toast.LENGTH_SHORT).show();
            }
        });


        Button prevButton = findViewById(R.id.explore_page_button1);

        // Set click listener for the Previous button
        prevButton.setOnClickListener(v -> {
            // Navigate back to the home page (activityHomepage)
            Intent intent2 = new Intent(this, activityHomepage.class);

            startActivity(intent2);
        });

    }


    /**
     * Parses the selected dropdown item representing the number of travelers into an integer value.
     *
     * @param numberOfTravelers The selected dropdown item representing the number of travelers.
     * @return The parsed integer value representing the number of travelers.
     */
    public int parseDropdownItem(String numberOfTravelers) {
        // Default value
        int numberOfPersons = 1;
        switch (numberOfTravelers) {
            case "Single Person 1":
                numberOfPersons = 1;
                break;
            case "Group of 2":
                numberOfPersons = 2;
                break;
            case "Group of 3":
                numberOfPersons = 3;
                break;
            case "Group of 4":
                numberOfPersons = 4;
                break;
            case "Group of 5 People Maximum":
                numberOfPersons = 5;
                break;
        }
        return numberOfPersons;
    }
}




