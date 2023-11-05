package com.example.nirvana;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText repassword;
    dbHandler dbhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = findViewById(R.id.editText2);
        password = findViewById(R.id.editTextP2);
        repassword = findViewById(R.id.editTextP3);
    }

    public void Signup2(View view) {
        if(password.getText().toString().equals(repassword.getText().toString())){
            dbhandler = new dbHandler(Signup.this);
            dbhandler.addUser(username.getText().toString(),password.getText().toString());
            Toast.makeText(Signup.this,"Signup Successful!",Toast.LENGTH_SHORT).show();
            Intent I = new Intent(this, Mood.class);
            I.putExtra("username",username.getText().toString());
            startActivity(I);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
            builder.setMessage("PASSWORDS DO NOT MATCH");
            builder.setTitle("Alert!");
            builder.setCancelable(false);
            builder.setNegativeButton("OK",(DialogInterface.OnClickListener) (dialog, which) ->{
                dialog.cancel();
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}