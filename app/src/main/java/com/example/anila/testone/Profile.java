package com.example.anila.testone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView name, email,ph,dob,user,pass;
        name=findViewById(R.id.user_name);
        email=findViewById(R.id.user_email);
        ph=findViewById(R.id.user_phone);
        dob=findViewById(R.id.user_dob);

        pass=findViewById(R.id.user_password);

        name.setText("Name : "+UserDetails.getUserFirst_Name()+" "+UserDetails.getUserLast_Name());
        email.setText("Email : "+UserDetails.getEmail());
        ph.setText("phone : "+UserDetails.getPhoneNo());
        dob.setText("Dob : "+UserDetails.getDate_of_birth());
        pass.setText("Password : "+UserDetails.getConfirmPassWord());

    }
}
