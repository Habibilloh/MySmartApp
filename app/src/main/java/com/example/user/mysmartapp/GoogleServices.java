package com.example.user.mysmartapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GoogleServices extends AppCompatActivity {
    Button cord, weath, gog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_services);
        cord=(Button)findViewById(R.id.cordinator);
        cord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cordinator = new Intent(GoogleServices.this, Coordetect.class);
                startActivity(cordinator);
            }
        });
        weath=(Button)findViewById(R.id.weather);
        weath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weather = new Intent(Intent.ACTION_VIEW, Uri.parse("https://weather.com/en-GB"));
                startActivity(weather);
            }
        });
        gog=(Button)findViewById(R.id.gogs);
        gog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(gog);
            }
        });
    }
}
