package com.example.tripplannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class displayDownloadedFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_downloaded_file);

        TextView fileContentTextView = findViewById(R.id.fileContentTextView);
        Button backButton = findViewById(R.id.backButton);

        // Retrieve the downloaded file content and display it in TextView
        String fileContent = getIntent().getStringExtra("fileContent");
        fileContentTextView.setText(fileContent);

        // Retrieve the file content from the intent
        Intent intent = getIntent();

        // Set the file content to the TextView
        fileContentTextView.setText(fileContent);

        // Set OnClickListener for the back button to finish the activity or to go back where the user were
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

