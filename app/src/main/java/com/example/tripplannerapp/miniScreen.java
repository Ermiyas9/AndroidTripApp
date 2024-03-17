/** ================================================================================================*/
/** FILE               : miniScreen.java                                                            */
/** PROJECT            : Trip Planner App (Assignment 2)                                            */
/** PROGRAMMER         : Ermiyas (Endalkachew) Gulti                                                */
/** FIRST VERSION      : 2024-March-14                                                              */
/** DESCRIPTION        : Represents the mini screen activity where details of a food item are       */
/**                     : displayed. Allows users to download a file asynchronously and navigate   */
/**                     : to another activity to display the downloaded file.                      */
/**=================================================================================================*/

package com.example.tripplannerapp;

// Imports
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class miniScreen extends AppCompatActivity {

    // Name of the file to save the downloaded content
    private static final String FILENAME = "downloadedFile.txt";

    double foodPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_screen);

        // Find the download button by its ID
        Button downloadButton = findViewById(R.id.downloadButton);

        String foodName = getIntent().getStringExtra("foodName");
        String mealCategory = getIntent().getStringExtra("mealCategories");
        foodPrice = getIntent().getDoubleExtra("foodPrice", 0.0);
        String foodDescription = getIntent().getStringExtra("foodDescription");
        int foodImage = getIntent().getIntExtra("foodImage", 0);
        double preparationTime = getIntent().getDoubleExtra("preparationTimeMinutes", 0.0);

        ImageView foodImageView = findViewById(R.id.foodImage);
        TextView preparationTimeTextView = findViewById(R.id.preparationTime);
        TextView foodNameTextView = findViewById(R.id.foodName);
        TextView mealCategoriesTextView = findViewById(R.id.mealCategories);
        TextView foodPriceTextView = findViewById(R.id.foodPrice);
        TextView foodDescriptionTextView = findViewById(R.id.foodDescription);

        foodImageView.setImageResource(foodImage);
        preparationTimeTextView.setText(String.valueOf(preparationTime));
        foodNameTextView.setText(foodName);
        mealCategoriesTextView.setText(foodDescription);
        foodPriceTextView.setText(String.valueOf(foodPrice));
        foodDescriptionTextView.setText(foodDescription);

        // Set up OnClickListener for the download button
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Execute the DownloadFileTask when the download button is clicked
                new DownloadFileTask().execute("https://filesamples.com/samples/document/txt/sample3.txt");

                // Create an intent to start the second database activity
                Intent intent2 = new Intent(miniScreen.this, activityDatabaseRecord.class);

                // Put extras (destination and total cost) to the intent for the second activity
                intent2.putExtra("foodPrice", foodPrice);
            }
        });
    }

    /**
     * Handles the back button click event.
     *
     * @param view The View object that was clicked.
     */
    public void goBack(View view) {
        finish();
    }

    /**
     * DownloadFileTask is an AsyncTask that downloads a file from a given URL
     * and saves it to the internal storage of the device.
     */
    private class DownloadFileTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                // Get the URL
                URL url = new URL(params[0]);

                // Get the input stream from the URL
                InputStream in = url.openStream();

                // Get the output stream to write the downloaded data to the file
                FileOutputStream out = openFileOutput(FILENAME, Context.MODE_PRIVATE);

                // Read data from the input stream and write it to the output stream
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                // Close streams
                out.close();
                in.close();

            } catch (IOException e) {
                // Handle IO exceptions, e.g., network issues, file writing errors
                Log.e("DownloadFileTask", "Error downloading file: " + e.getMessage());
            }

            return null;
        }

        /**
         * This method is called after the file is downloaded and saved.
         * It logs a success message, displays a toast to notify the user about the successful download,
         * reads the downloaded file's content, and passes it to a new activity to display.
         *
         * @param result The result of the AsyncTask execution.
         */
        @Override
        protected void onPostExecute(Void result) {

            // method will executed after the file is downloaded and saved
            Log.d("DownloadFileTask", "File downloaded successfully");

            // Display a toast message to notify the user
            Toast.makeText(miniScreen.this, "File downloaded successfully", Toast.LENGTH_SHORT).show();

            // Read the downloaded file and its content to pass to the new activity
            StringBuilder sb = new StringBuilder();
            try {
                FileInputStream fis = openFileInput(FILENAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Create an Intent to start the new activity and pass the file content
            Intent intent = new Intent(miniScreen.this, displayDownloadedFile.class);
            intent.putExtra("fileContent", sb.toString());
            startActivity(intent);
        }
    }
}
