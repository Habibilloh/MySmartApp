package com.example.user.mysmartapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MindReader extends AppCompatActivity {
    private TextView tv_inf;
    private Button b_yes, b_higher, b_lower, b_ok;
    private int tries=0;
    private int left=1, right=1000;
    private int mid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_reader);
        tv_inf=(TextView)findViewById(R.id.tv_info);
        b_yes=(Button)findViewById(R.id.b_yes);
        b_ok=(Button)findViewById(R.id.b_ok);
        b_higher=(Button)findViewById(R.id.b_higher);
        b_lower=(Button)findViewById(R.id.b_lower);


        b_yes.setVisibility(View.INVISIBLE);
        b_higher.setVisibility(View.INVISIBLE);
        b_lower.setVisibility(View.INVISIBLE);

        tv_inf.setText("Think any number between 1 to 1000 and I will guess it under 10 moves.");

        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_yes.setVisibility(View.VISIBLE);
                b_higher.setVisibility(View.VISIBLE);
                b_lower.setVisibility(View.VISIBLE);
                b_ok.setVisibility(View.INVISIBLE);

                guess();

            }
        });
        b_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_inf.setText("Woow! I guessed it in "+tries+" moves. Awsome right?");

                b_yes.setVisibility(View.INVISIBLE);
                b_higher.setVisibility(View.INVISIBLE);
                b_lower.setVisibility(View.INVISIBLE);
                b_ok.setVisibility(View.VISIBLE);

                b_ok.setText("New Game");

                tries=0;
                left=1;
                right=1000;

            }
        });
        b_higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left=mid+1;
                guess();

            }
        });
        b_lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right=mid-1;
                guess();

            }
        });
    }
    private void guess(){
        mid=(left+right)/2;
        tries++;
        tv_inf.setText("My guess is "+mid);
    }
}
