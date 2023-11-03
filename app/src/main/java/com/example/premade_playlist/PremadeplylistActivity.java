package com.example.premade_playlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class PremadeplylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premadeplaylist);

        // Find all your ImageViews by their IDs
        ImageView myImageView = findViewById(R.id.myImageView);
        ImageView myImageView2 = findViewById(R.id.myImageView2);
        ImageView myImageView3 = findViewById(R.id.myImageView3);
        ImageView myImageView4 = findViewById(R.id.myImageView4);
        ImageView myImageView5 = findViewById(R.id.myImageView5);
        ImageView myImageView6 = findViewById(R.id.myImageView6);

        // Set click listeners for each ImageView
        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PremadeplylistActivity.this, MarathiActivity.class);
                startActivity(intent);
            }
        });

        myImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PremadeplylistActivity.this, EnglishActivity.class);
                startActivity(intent);
            }
        });

        myImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PremadeplylistActivity.this, HindiActivity.class);
                startActivity(intent);
            }
        });

        myImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PremadeplylistActivity.this, SanskritActivity.class);
                startActivity(intent);
            }
        });

        myImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PremadeplylistActivity.this, TamilActivity.class);
                startActivity(intent);
            }
        });

        myImageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PremadeplylistActivity.this, GujaratiActivity.class);
                startActivity(intent);
            }
        });
    }


}
