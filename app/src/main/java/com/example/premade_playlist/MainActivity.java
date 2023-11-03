package com.example.premade_playlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure you have the correct layout XML file.

        Button nextScreenButton = findViewById(R.id.button); // Replace "button" with your button's ID.

        nextScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the NextScreenActivity.
                Intent intent = new Intent(MainActivity.this, PremadeplylistActivity.class);
                startActivity(intent);
            }
        });
    }
}
