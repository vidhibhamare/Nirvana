package com.example.premade_playlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MarathiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marathi);

        Button song1Button = findViewById(R.id.button2);
        Button song2Button = findViewById(R.id.button3);
        Button song3Button = findViewById(R.id.button4);

        song1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarathiActivity.this, PlaybackActivity.class);
                intent.putExtra("SONG_TITLE", "Song 13"); // Pass song details
                startActivity(intent);
            }
        });

        song2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarathiActivity.this, PlaybackActivity.class);
                intent.putExtra("SONG_TITLE", "Song 14"); // Pass song details
                startActivity(intent);
            }
        });

        song3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarathiActivity.this, PlaybackActivity.class);
                intent.putExtra("SONG_TITLE", "Song 15"); // Pass song details
                startActivity(intent);
            }
        });


    }
}

