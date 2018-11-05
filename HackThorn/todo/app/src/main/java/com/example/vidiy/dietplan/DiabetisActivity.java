package com.example.vidiy.dietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiabetisActivity extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fever );
        textView=(TextView) findViewById( R.id.txtdrug );
        textView.setText( "•\tDIOVAN    \n" +
                "•\tAMIODARONE HCL \n" +
                "•\tPREDNISOLONE\n" +
                "•\tPREDNISOLONE SODIUM PHOSPHATE\n" +
                "•\tMILLIPRED\n" );

        textView1=(TextView) findViewById( R.id.txtdiet);
        textView1.setText( "1.\tFatty Fish. Fatty fish is one of the healthiest foods on the planet. ...\n" +
                "2.\tLeafy Greens. Leafy green vegetables are extremely nutritious and low in calories. ...\n" +
                "3.\tCinnamon. Cinnamon is a delicious spice with potent antioxidant activity. ...\n" +
                "4.\tEggs. Eggs provide amazing health benefits. ...\n" +
                "5.\tChia Seeds. ...\n" +
                "6.\tTurmeric. ...\n" +
                "7.\tGreek Yogurt. ...\n" +
                "8.\tNuts.\n" );

        button = (Button) findViewById(R.id.bttrack );

    }
    public void track(View view)
    {
        Intent i =new Intent(this,TrackActivity.class);
        startActivity(i);

    }
}
