package com.example.vidiy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login1);
    }
    public void login(View v)
    {
        //Getting values from text fields controls.
        EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        TextView lblUsernameError = (TextView) findViewById(R.id.lblUsernameError);
        TextView lblPasswordError = (TextView) findViewById(R.id.lblPasswordError);

        //Getting values from controls.
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        //Setting empty string to the error labels.
        lblUsernameError.setText("");
        lblPasswordError.setText("");

        //Checking the username is empty or not.
        if(username.isEmpty())
        {
            lblUsernameError.setText("Please enter the username.");
        }
        //Checking the password is empty or not.
        else if(password.isEmpty())
        {
            lblPasswordError.setText("Please enter password");
        }
        //Validating the username and password.
        else if(username.equalsIgnoreCase("srinu") && password.equals("Srinu"))
        {
            Intent redirect = new Intent(LoginActivity1.this,HomeActivity.class).putExtra("username",username);
            startActivity(redirect);
        }
        else {
            lblPasswordError.setText("Invalid Username/Password.");
        }
    }


}
