package com.example.vidiy.dietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FeverActivity extends AppCompatActivity {
   TextView textView;
    TextView textView1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fever );
        textView=(TextView) findViewById( R.id.txtdrug );
        textView.setText( "Aspirin\n" +
                "Ibuprofen\n" +
                "Magnesium Salicylateo\n" +
                "Naproxen Sodium" );

        textView1=(TextView) findViewById( R.id.txtdiet);
        textView1.setText( "BreakFast:Milk n Cornflakes \n" +
                "Mid-Meal:Tender coconut water (1 cup) + 1 Apple\n" +
                "Lunch:Parboiled rice (1/2 cup) + Chicken(2pcs.) stew (1/2 cup)\n" +
                "Dinner:Boiled rice (1/3 cup) + Mashed potato (2) + Ghee (1tsp) + Warm Rasgolla (2)" );

        button = (Button) findViewById(R.id.bttrack );

    }
    public void track(View view)
    {
        Intent i =new Intent(this,TrackActivity.class);
        startActivity(i);

    }


}
