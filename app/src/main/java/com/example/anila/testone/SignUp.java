package com.example.anila.testone;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    Button b;
    EditText firstName, lastName, email, phoneNo, dateOfBirth, passWord, confirmPass;
    String userFirstName, userLastName, userPhoneno, userEmail, userDob, confirmPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = findViewById(R.id.button);
        firstName = findViewById(R.id.reg_fname);
        lastName = findViewById(R.id.reg_lname);
        email = findViewById(R.id.reg_email);
        phoneNo = findViewById(R.id.reg_phno);
        dateOfBirth = findViewById(R.id.reg_dob);
        passWord = findViewById(R.id.reg_password);
        confirmPass = findViewById(R.id.reg_conifrm_passWord);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFirstName = firstName.getText().toString().trim();
                userLastName = lastName.getText().toString().trim();
                userPhoneno = phoneNo.getText().toString().trim();
                userEmail = email.getText().toString().trim();
                userDob = dateOfBirth.getText().toString().trim();
                confirmPassword = confirmPass.getText().toString().trim();
                Pattern namePattern = Pattern.compile("[A-Za-z]{1,10}");
                Matcher firstnameMatch = namePattern.matcher(userFirstName);
                Matcher lastnameMatch = namePattern.matcher(userLastName);
                Pattern emailPattern = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");
                Matcher emailMatch = emailPattern.matcher(userEmail);
                Pattern phPattern = Pattern.compile("^[7-9][0-9]{9}$");
                Matcher phoneMatch = phPattern.matcher(userPhoneno);
                if(!(firstnameMatch.matches()||!(lastnameMatch.matches())))
                {
                    firstName.setError("inappropriate Name");

                }
                if(!(emailMatch.matches())){
                    email.setError("Please enter a valid email address");
                }
                if(!(phoneMatch.matches()))
                {
                    phoneNo.setError("Please enter a valid phone number");
                }
                else {
                    Toast.makeText(SignUp.this, "UserRegistration completed", Toast.LENGTH_SHORT).show();
                    UserDetails ud = new UserDetails(userFirstName, userLastName, userPhoneno, userEmail, userDob, confirmPassword);
                    Intent myIntent = new Intent(SignUp.this, Login.class);
                    SignUp.this.startActivity(myIntent);
                }


//                if (f_nameMatch.matches() && l_nameMatch.matches())
//                    if (emailMatch.matches() && phoneMatch.matches()) {
//                        Toast.makeText(SignUp.this, "UserRegistration completed", Toast.LENGTH_SHORT).show();
//                        UserDetails ud = new UserDetails(userFirstName, userLastName, userPhoneno, userEmail, userDob, confirmPassword);
//                        Intent myIntent = new Intent(SignUp.this, Login.class);
//                        SignUp.this.startActivity(myIntent);
//                    } else
//                        Toast.makeText(SignUp.this, "INVALID", Toast.LENGTH_SHORT).show();

            }
        });
        }

    public void getdate(View view){
        final Calendar c = Calendar.getInstance();
        int currentYear,currentMonth,currentDay;
        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateOfBirth.setText(dayOfMonth+"-"+month+"-"+year);
            }
        }, currentYear, currentMonth, currentDay);
        datePickerDialog.show();
    }

}
