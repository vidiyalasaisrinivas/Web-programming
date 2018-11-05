package com.example.vidiy.dietplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackActivity extends AppCompatActivity {
    EditText diet;
    TextView txt;

    static final String TAG = "FragmentActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_track );
    }

    public void cal(View view) {
        // https://api.nutritionix.com/v1_1/search/chicken?results=0:1&fields=*&appId=9b957ac3&appKey=e50e0ceeb9749bef58010d5412027c35
        //        JSONObject json = readurl("https://api.nutritionix.com/v1_1/search/chicken?results=0:1&fields=*&appId=9b957ac3&appKey=e50e0ceeb9749bef58010d5412027c35");
        //        JSONArray dataJsonArray = json.getJSONArray("data");
        //        for(int i=0; i<dataJsonArray.length; i++) {
        //            JSONObject dataObj = dataJsonArray.get(i);
        //            String id = dataObj.getString("id");*/
        //
        //       // new JsonTask().execute("Url address here");

       diet =(EditText) findViewById( R.id.etdiet );
       String s1= diet.getText().toString();
       txt =(TextView) findViewById( R.id.txtresult );
        HttpHandler sh = new HttpHandler();
       // String search=s1;
        // Making a request to url and getting response
        String url = "https://api.nutritionix.com/v1_1/"+s1+"/?results=0:1&fields=*&appId=9b957ac3&appKey=e50e0ceeb9749bef58010d5412027c35";
        String jsonStr = sh.makeServiceCall( url );

        Log.d( TAG, "Response from url: " + jsonStr );
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject( jsonStr );

                // Getting JSON Array node
                JSONArray calories = jsonObj.getJSONArray( "hits" );

                // looping through All hits
                for (int i = 0; i < calories.length(); i++) {
                    JSONObject c = calories.getJSONObject( i );
                    String cal = c.getString( "nf_calories" );
                    txt.setText("calories"+ cal );

                }

            }//try
            catch (final JSONException e) {
                Log.e( TAG, "Json parsing error: " + e.getMessage() );
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText( getApplicationContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG ).show();
                    }
                } );

            }
        }
    }}