

package com.example.dlgandroidtest;

import static android.util.Patterns.EMAIL_ADDRESS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Patterns;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.regex.Pattern;

public class GFlag extends AppCompatActivity {

    EditText email, pswd, repeatPswd;
    Button btn;

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?:(?=.*[a-z])(?:(?=.*[A-Z])(?=.*[\\d\\W])|(?=.*\\W)(?=.*\\d))|(?=.*\\W)(?=.*[A-Z])(?=.*\\d)).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gflag);

        //enables back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = (EditText) findViewById(R.id.eml_text);
        pswd = (EditText) findViewById(R.id.pswd1);
        repeatPswd = (EditText) findViewById(R.id.rpt_pswd);
        btn = (Button) findViewById(R.id.btnNxt);


        btn.setOnClickListener(view -> {
            if (!validateEmail()){
                Toast.makeText(GFlag.this, "Invalid email address", Toast.LENGTH_SHORT).show();
            } else if (!isValidPassword()) {

                Toast.makeText(GFlag.this, "Invalid password", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(GFlag.this, "Succefully signed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean validateEmail() {

        // Extract input from EditText
        String emailInput = email.getText().toString().trim();

        // if the email input field is empty
        if (emailInput.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        }

        // Matching the input email to a predefined email pattern
        else if (!EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    public boolean isValidPassword(){

        String pswdInput = pswd.getText().toString().trim();
        String rePswdIn = repeatPswd.getText().toString().trim();

        if (pswdInput.isEmpty()){
            pswd.setError("Field can not be empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(pswdInput).matches()){
            pswd.setError("Please reed the instruction below");
            return false;
        }
        else if (!pswdInput.equals(rePswdIn)){
            repeatPswd.setError("Password don't match");

        }else{
            pswd.setError(null);
            return true;
        }

        return false;
    }




}


