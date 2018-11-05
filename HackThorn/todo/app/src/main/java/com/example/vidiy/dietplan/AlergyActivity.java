package com.example.vidiy.dietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlergyActivity extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fever );
        textView=(TextView) findViewById( R.id.txtdrug );
        textView.setText( "Avonex\n" +
                "Claritin, \n" +
                "Zyrtec,\n" +
                "Tysabri\n" +
                "Advair Hfa\n" +
                "Tecfidera\n" );

        textView1=(TextView) findViewById( R.id.txtdiet);
        textView1.setText( "nuts \n" +
                "grapes\n" +
                "oranges\n" +
                "apples\n" +
                "fresh tomatoes\n" );

        button = (Button) findViewById(R.id.bttrack );

    }
    public void track(View view)
    {
        Intent i =new Intent(this,TrackActivity.class);
        startActivity(i);

    }
}
