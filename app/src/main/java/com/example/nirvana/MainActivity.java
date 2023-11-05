package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void Login(View view) {
        Intent I = new Intent(this, Login.class);
        startActivity(I);
    }

    public void Signup(View view) {
        Intent I = new Intent(this, Signup.class);
        startActivity(I);
    }
}