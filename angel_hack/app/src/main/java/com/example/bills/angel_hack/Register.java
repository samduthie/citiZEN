package com.example.bills.angel_hack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText e_username, e_password, e_email, e_location;
    String username, password, email, location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e_username = (EditText) findViewById(R.id.username);
        e_password = (EditText) findViewById(R.id.password);
        e_email = (EditText) findViewById(R.id.email);
        e_location = (EditText) findViewById(R.id.location);

    }

    public void reguser(View view){

        username = e_username.getText().toString();
        password = e_password.getText().toString();
        location = e_location.getText().toString();
        email = e_email.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, username,password,email, location);
        finish();
    }
}
