package com.example.vidiy.coffeorder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    public void decrement(View view) {
        quantity=quantity-1;
        displayquantity(quantity);

    }

    private void displayquantity(int quantity) {
        EditText quantity1 = (EditText) findViewById(R.id.quantityTxt);
        quantity1.setText(""+quantity);


    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayquantity(quantity);
    }





    public void displayMessage(String finalMessage) {
        //TextView Message = (TextView) findViewById(R.id.resultTxt);
        //Message.setText(""+finalMessage);
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("mes", finalMessage);
        startActivity(intent);


    }

    public String createFinalMessage(String names, Boolean chocs, Boolean whipped,int price) {
        String Message = "Name: "+names+"\n"+"chocolate ordered :"+chocs+"\n"+"whipped ordered  :"+whipped+"\n"+" Total Price $: "+price;
        return  Message;


    }

    public int calculatePrice(Boolean chocs, Boolean whipped) {
        int price =10;
        if (chocs)
        {
            price =price+2;
        }
        if (whipped)
        {
            price=price+3;
        }
        return price*quantity;
    }

    //write navigation to summary and in summary write this code to display
    public void orderButton(View view) {
        EditText name = (EditText) findViewById(R.id.nameTxt);

        String names = name.getText().toString();
        CheckBox choc = (CheckBox) findViewById(R.id.chocalate_checkbox);
        Boolean chocs = choc.isChecked();
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean whipped = whippedCream.isChecked();
        int price = calculatePrice(chocs,whipped);
        String finalMessage =createFinalMessage (names,chocs,whipped,price);
        displayMessage(finalMessage);
    }

    public void sendEmail(String output) {
        // Write the relevant code for triggering email

        // Hint to accomplish the task

        /*Intent intent = new Intent(Intent.ACTION_VIEW);
        if (intent.resolveActivity(getPackageManager()) !=null){
            startActivity(intent);
        }*/


    }
    public void onlyOrder(View view)
    {
        EditText name = (EditText) findViewById(R.id.nameTxt);
        String names = name.getText().toString();
        CheckBox choc = (CheckBox) findViewById(R.id.chocalate_checkbox);
        Boolean chocs = choc.isChecked();
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean whipped = whippedCream.isChecked();
        int price = calculatePrice(chocs,whipped);
        String finalMessage =createFinalMessage (names,chocs,whipped,price);

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"vidiyala.saisrinivas@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject is project");
        i.putExtra(Intent.EXTRA_TEXT   , finalMessage);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }

}
