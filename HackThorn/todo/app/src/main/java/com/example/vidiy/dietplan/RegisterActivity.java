package com.example.vidiy.dietplan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Console;

public class RegisterActivity extends AppCompatActivity {
    SharedPreferences SharedPreferences;
    android.content.SharedPreferences.Editor editor;
    Button buttonReg2;
    EditText txtUsername, txtPassword, txtAge;
    UserSession session;
    Spinner dropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );
        //get the spinner from the xml.
         //dropdown = findViewById(R.id.spinner1);
       //create a list of items for the spinner.
       // String[] items = new String[]{"Fever", "Blood Pressure", "Asthma"};
       //create an adapter to describe how the items are displayed, adapters are used in several places in android.
       //There are multiple variations of this, but this is the basic variant.
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
       // dropdown.setAdapter(adapter);

        txtUsername = (EditText) findViewById(R.id.etname);
        txtPassword = (EditText) findViewById(R.id.etpass);
        txtAge = (EditText) findViewById(R.id.etage);
        buttonReg2 = (Button) findViewById(R.id.button);

        SharedPreferences = getSharedPreferences("RegisterActivity", 0);
// get editor to edit in file
        editor = SharedPreferences.edit();

        buttonReg2.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v) {
                String name = txtUsername.getText().toString();
                //log.e(name);
                //System.out.print
                //Log.i( "name" + name );
                //Log.d("name","name");
                String Age = txtAge.getText().toString();
                System.out.print( Age );
                String pass = txtPassword.getText().toString();
                //System.out.print( pass );
                //int i=0;
                //Log.isLoggable( pass,i );
                //String drop = dropdown.getSelectedItem().toString();
                //System.out.print( drop );
               // Log.d("drop","drop");
                if(txtUsername.getText().length()<=0){
                    Toast.makeText(RegisterActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if( txtAge.getText().length()<=0){
                    Toast.makeText(RegisterActivity.this, "Enter Age", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if( txtPassword.getText().length()<=0){
                    Toast.makeText(RegisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{



                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("Email",Age);
                    editor.putString("Pass",pass);
                    //editor.putString("disease",drop);
                    editor.commit();}   // commit the values

                // after saving the value open next activity
                 Intent ob = new Intent(RegisterActivity.this, HomeActivity.class);
                 startActivity(ob);

            }
        });
    }

}
