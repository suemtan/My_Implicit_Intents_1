package com.example.sutan.my_implicit_intents;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runWebsite =(Button) findViewById(R.id.btn_launch);

        runWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText website = (EditText) findViewById(R.id.url);
                String strURL = website.getText().toString();
                if (strURL.indexOf("http://www") < 0) {
                    strURL = "http://www." + strURL;
                }
                Intent implicit = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(strURL));
                startActivity(implicit);
            }
        });

        //button
        Button dialPhNumber = (Button) findViewById(R.id.btn_Ring);
        dialPhNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText phNumber = (EditText) findViewById(R.id.phone);
                Intent implicit = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:"+phNumber.getText().toString()));

                startActivity(implicit);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
