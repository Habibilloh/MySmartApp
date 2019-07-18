package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Multimedia extends AppCompatActivity {
    Button mus, vid, piano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        mus=(Button)findViewById(R.id.music);
        mus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent music = new Intent(Multimedia.this, MusicPlayer.class);
                startActivity(music);
            }
        });
        piano=(Button)findViewById(R.id.pian);
        piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent piano = new Intent(Multimedia.this, Piano.class);
                startActivity(piano);
            }
        });
    }
}
