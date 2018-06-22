package com.example.anila.testone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    Button b1, b2;
    EditText passWord, userName;
    String name, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        b1 = findViewById(R.id.button);
        passWord = findViewById(R.id.password);
        userName = findViewById(R.id.username);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Login.this, SignUp.class);
                Login.this.startActivity(myIntent);

            }
        });
        b2 = findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = userName.getText().toString().trim();
                userPassword = passWord.getText().toString().trim();
                //Validation of the Email and password in the login page
                if (name.equals(UserDetails.getEmail()) && userPassword.equals(UserDetails.getConfirmPassWord())) {
                    Intent myIntent = new Intent(Login.this, Profile.class);
                    Login.this.startActivity(myIntent);
                }
            }
        });


    }
}
