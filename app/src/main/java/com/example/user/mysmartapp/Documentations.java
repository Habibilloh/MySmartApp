package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Documentations extends AppCompatActivity {
    Button calcu, calend, notep,stopw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentations);
        calcu=(Button)findViewById(R.id.calculator);
        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calculator = new Intent(Documentations.this, Calculator.class);
                startActivity(calculator);
            }
        });
        calend=(Button)findViewById(R.id.calen);
        calend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calendar = new Intent(Documentations.this, Calendar.class);
                startActivity(calendar);
            }
        });
        notep=(Button)findViewById(R.id.notepad);
        notep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notepad = getPackageManager().getLaunchIntentForPackage("com.example.user.notepad");
                startActivity(notepad);
            }
        });
        stopw=(Button)findViewById(R.id.stopwatch);
        stopw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopwatch = new Intent(Documentations.this, Stopwatch.class);
                startActivity(stopwatch);
            }
        });
    }
}
