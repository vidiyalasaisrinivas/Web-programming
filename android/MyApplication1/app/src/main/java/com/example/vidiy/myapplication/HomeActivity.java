package com.example.vidiy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView lblName = findViewById(R.id.lblName);
        String username = getIntent().getStringExtra("username");
        lblName.setText("Hi " + username);
    }
    public void logout(View view)
    {
        Intent redirect = new Intent(HomeActivity.this,LoginActivity1.class);
        startActivity(redirect);
    }
}
