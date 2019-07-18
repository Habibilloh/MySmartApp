package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicTacToe extends AppCompatActivity {
    Button btstart, bthelpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        btstart = (Button) findViewById(R.id.start);
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(TicTacToe.this, MainGameBoard.class);
                startActivity(myIntent);
            }
        });


        bthelpp = (Button) findViewById(R.id.bthelp);
        bthelpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(TicTacToe.this, Help.class);
                startActivity(myIntent2);
            }
        });
    }
    public void clickexit (View v){
//        moveTaskToBack(true);
//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(1);
        Intent back = new Intent(TicTacToe.this, Games.class);
        startActivity(back);
    }
}
