package com.example.vidiy.dietplan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.vidiy.dietplan.UserSession.PREFER_NAME;
import static java.lang.System.console;

public class HomeActivity extends AppCompatActivity {
    Button buttonLogin;
    android.content.SharedPreferences SharedPreferences;

    EditText txtUsername, txtPassword;

    // User Session Manager Class
    UserSession session;
    Button txtsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        txtsignup = (Button) findViewById( R.id.etregister );

        txtsignup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HomeActivity.this, RegisterActivity.class );
                HomeActivity.this.startActivity( intent );
            }

        } );

        session = new UserSession(getApplicationContext());

        // get Email, Password input text
        txtUsername = (EditText) findViewById(R.id.etusername);
        txtPassword = (EditText) findViewById(R.id.etpassword);

        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();


        // User Login button
        buttonLogin = (Button) findViewById(R.id.etlogin);

        SharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        buttonLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get username, password from EditText
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                // Validate if username, password is filled
                if(username.trim().length() > 0 && password.trim().length() > 0) {
                    String uName = null;
                    String uPass = null;


                    if (SharedPreferences.contains( "name" )) {
                        uName = ( SharedPreferences ).getString( "Name", "" );

                    }

                    if (SharedPreferences.contains( "Pass" )) {
                        uPass = ( SharedPreferences ).getString( "Pass", "" );

                    }
                    //Log.d("name",uName.toString());
                    //Log.d("pass",uPass.toString());
                    System.out.print( "nameis" + uName );
                    //Object uName = null;
                    //Object uPass = null;
                    if (username.equals( "sai" ) && password.equals( "sai" )) {
                        session.createUserLoginSession( uName,
                                uPass );

                        // Starting MainActivity
                        Intent i = new Intent( getApplicationContext(), DietActivity.class );
                        i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );

                        // Add new Flag to start new Activity
                        i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
                        startActivity( i );

                        finish();
                    } else {
                        Toast.makeText( getApplicationContext(),
                                "Username/Password is incorrect",
                                Toast.LENGTH_LONG ).show();

                    }
                    //(uName);
                   /* if(username.equals(uName) && password.equals(uPass)){

                        session.createUserLoginSession(uName,
                                uPass);

                        // Starting MainActivity
                        Intent i = new  Intent(getApplicationContext(),HomeActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);

                        finish();

                    }else{

                        // username / password doesn't match&
                        Toast.makeText(getApplicationContext(),
                                "Username/Password is incorrect",
                                Toast.LENGTH_LONG).show();

                    }
                }else{

                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(),
                            "Please enter username and password",
                            Toast.LENGTH_LONG).show();

                }*/
                }
            }
        } );


    } //onCreate*/


    }



