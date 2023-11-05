package com.example.nirvana;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editText1;
    EditText editTextP1;
    dbHandler dbhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = findViewById(R.id.editText1);
        editTextP1 = findViewById(R.id.editTextP1);
    }

    public void Login2(View view) {
        dbhandler = new dbHandler(Login.this);
        Boolean checkuser = dbhandler.checkUsername(editText1.getText().toString());
        Boolean checkuserpass = dbhandler.checkUserAndPassword(editText1.getText().toString(),editTextP1.getText().toString());
        if(checkuser){
            if(checkuserpass){
                Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                Intent I = new Intent(this, Mood.class);
                I.putExtra("username",editText1.getText().toString());
                I.putExtra("password",editTextP1.getText().toString());
                startActivity(I);
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setMessage("WRONG PASSWORD");
                builder.setTitle("Alert!");
                builder.setCancelable(false);
                builder.setNegativeButton("OK",(DialogInterface.OnClickListener) (dialog, which) ->{
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
            builder.setMessage("Username does not exist");
            builder.setTitle("Alert!");
            builder.setCancelable(false);
            builder.setNegativeButton("Try Again",(DialogInterface.OnClickListener) (dialog, which) ->{
                dialog.cancel();
            });
            builder.setPositiveButton("Signup",(DialogInterface.OnClickListener)(dialog,which) ->{
                Intent I = new Intent(this, Signup.class);
                startActivity(I);
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}