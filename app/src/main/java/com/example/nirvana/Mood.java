package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Mood extends AppCompatActivity {
    Bundle extras;
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        extras = getIntent().getExtras();
        username = extras.getString("username");
    }

    public void Happy(View view) {
        Intent I = new Intent(this, homePage.class);
        I.putExtra("mood","Happy");
        I.putExtra("username",username);
        startActivity(I);
    }

    public void Sad(View view) {
        Intent I = new Intent(this, homePage.class);
        I.putExtra("mood","Sad");
        I.putExtra("username",username);
        startActivity(I);
    }

    public void Romantic(View view) {
        Intent I = new Intent(this, homePage.class);
        I.putExtra("mood","Romantic");
        I.putExtra("username",username);
        startActivity(I);
    }

    public void Energetic(View view) {
        Intent I = new Intent(this, homePage.class);
        I.putExtra("mood","Energetic");
        I.putExtra("username",username);
        startActivity(I);
    }

    public void Relaxed(View view) {
        Intent I = new Intent(this, homePage.class);
        I.putExtra("mood","Relaxed");
        I.putExtra("username",username);
        startActivity(I);
    }

    public void Indifferent(View view) {
        Intent I = new Intent(this, homePage.class);
        I.putExtra("mood","Indifferent");
        I.putExtra("username",username);
        startActivity(I);
    }

    public void spiritual(View view) {
        Intent I = new Intent(this, homePage.class);
        I.putExtra("mood","spiritual");
        I.putExtra("username",username);
        startActivity(I);
    }
}