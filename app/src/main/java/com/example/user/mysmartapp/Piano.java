package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Piano extends AppCompatActivity {
    Button grand,vintage,roy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        grand=(Button)findViewById(R.id.violen);
        grand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viole = new Intent(Piano.this, Violen.class);
                startActivity(viole);
            }
        });
        vintage=(Button)findViewById(R.id.vint);
        vintage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vintag = new Intent(Piano.this, Vintage.class);
                startActivity(vintag);
            }
        });
        roy=(Button)findViewById(R.id.royal);
        roy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent roya=new Intent(Piano.this, Royal.class);
                startActivity(roya);
            }
        });
    }
}
