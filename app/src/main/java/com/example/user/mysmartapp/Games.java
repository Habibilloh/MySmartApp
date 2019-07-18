package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Games extends AppCompatActivity {
    Button tic, braingame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        tic=(Button)findViewById(R.id.tictactoe);
        tic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tictac = new Intent(Games.this, TicTacToe.class);
                startActivity(tictac);
            }
        });
        braingame=(Button)findViewById(R.id.b_game);
        braingame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bgame=new Intent(Games.this, MindReader.class);
                startActivity(bgame);
            }
        });
    }
}
