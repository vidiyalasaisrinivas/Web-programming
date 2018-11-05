package com.example.vidiy.dietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DietActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_diet );



    }
    public void diet(View view)
    {
       editText =(EditText) findViewById(R.id.etsymptom );
       String s1=editText.getText().toString();
       if(s1.contains("fever"))
       {
         Intent i =new Intent(this,FeverActivity.class);
           startActivity(i);
       }
       if(s1.contains("cough"))
       {
           Intent i =new Intent(this,CoughActivity.class);
           startActivity(i);
       }
       if(s1.contains("alergy"))
       {
           Intent i = new Intent(this,AlergyActivity.class);
           startActivity( i );
       }
       if(s1.contains("Diabetis"))
       {
           Intent i = new Intent(this,DiabetisActivity.class);
           startActivity( i );
       }

    }




}
