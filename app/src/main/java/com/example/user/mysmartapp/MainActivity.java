package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.bloder.magic.view.MagicButton;

public class MainActivity extends AppCompatActivity {
    MagicButton docs, mult, gserv,gamee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        docs = (MagicButton) findViewById(R.id.documentation);
        docs.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent docums = new Intent(MainActivity.this, Documentations.class);
                startActivity(docums);
            }
        });

        mult=(MagicButton)findViewById(R.id.multimedia);
        mult.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent multim= new Intent(MainActivity.this, Multimedia.class);
                startActivity(multim);
            }
        });
        gserv=(MagicButton)findViewById(R.id.gservices);
        gserv.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gservices = new Intent(MainActivity.this, GoogleServices.class);
                startActivity(gservices);
            }
        });
        gamee=(MagicButton)findViewById(R.id.games);
        gamee.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent games = new Intent(MainActivity.this, Games.class);
                startActivity(games);
            }
        });
    }

    public void loadSlides(View view) {
        new PreferenceManager(this).clearPreferences();
        startActivity(new Intent(this, WelcomeActivity.class));
        finish();
    }
}
