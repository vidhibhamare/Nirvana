package com.example.premade_playlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class GujaratiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gujarati);

        Button song1Button = findViewById(R.id.button2);
        Button song2Button = findViewById(R.id.button3);
        Button song3Button = findViewById(R.id.button4);

        song1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GujaratiActivity.this, PlaybackActivity.class);
                intent.putExtra("SONG_TITLE", "Song 4"); // Pass song details
                startActivity(intent);
            }
        });

        song2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GujaratiActivity.this, PlaybackActivity.class);
                intent.putExtra("SONG_TITLE", "Song 5"); // Pass song details
                startActivity(intent);
            }
        });

        song3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GujaratiActivity.this, PlaybackActivity.class);
                intent.putExtra("SONG_TITLE", "Song 6"); // Pass song details
                startActivity(intent);
            }
        });


    }
}

