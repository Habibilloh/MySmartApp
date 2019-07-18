package com.example.user.mysmartapp;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Violen extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14;
    private SoundPool soundPool;
    private int s_1,s_2,s_3,s_4,s_5,s_6,s_7,s_8,s_9,s_10,s_11,s_12,s_13,s_14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool=new SoundPool.Builder().setMaxStreams(5).build();
        }else {
            soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }
        s_1=soundPool.load(this,R.raw.a, 1);
        s_2=soundPool.load(this,R.raw.b, 1);
        s_3=soundPool.load(this,R.raw.c, 1);
        s_4=soundPool.load(this,R.raw.d, 1);
        s_5=soundPool.load(this,R.raw.e, 1);
        s_6=soundPool.load(this,R.raw.f, 1);
        s_7=soundPool.load(this,R.raw.g, 1);
        s_8=soundPool.load(this,R.raw.h, 1);
        s_9=soundPool.load(this,R.raw.i, 1);
        s_10=soundPool.load(this,R.raw.j, 1);
        s_11=soundPool.load(this,R.raw.k, 1);
        s_12=soundPool.load(this,R.raw.l, 1);
        s_13=soundPool.load(this,R.raw.j, 1);
        s_14=soundPool.load(this,R.raw.k, 1);
        bt1=(Button)findViewById(R.id.b1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(s_1, 1,1,0,0,1);

            }
        });
        bt2=(Button)findViewById(R.id.b2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(s_2, 1,1,0,0,1);

            }
        });
        bt3=(Button)findViewById(R.id.b3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(s_3, 1,1,0,0,1);

            }
        });
        bt4=(Button)findViewById(R.id.b4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_4, 1,1,0,0,1);
            }
        });
        bt5=(Button)findViewById(R.id.b5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_5, 1,1,0,0,1);
            }
        });
        bt6=(Button)findViewById(R.id.b6);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_6, 1,1,0,0,1);
            }
        });
        bt7=(Button)findViewById(R.id.b7);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_7, 1,1,0,0,1);
            }
        });
        bt8=(Button)findViewById(R.id.b8);
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_8, 1,1,0,0,1);
            }
        });
        bt9=(Button)findViewById(R.id.b9);
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_9, 1,1,0,0,1);
            }
        });
        bt10=(Button)findViewById(R.id.b10);
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_10, 1,1,0,0,1);
            }
        });
        bt11=(Button)findViewById(R.id.b11);
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_11, 1,1,0,0,1);
            }
        });
        bt12=(Button)findViewById(R.id.b12);
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_12, 1,1,0,0,1);
            }
        });
        bt13=(Button)findViewById(R.id.b13);
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(s_13, 1,1,0,0,1);
            }
        });
        bt14=(Button)findViewById(R.id.b14);
        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(s_14, 1,1,0,0,1);

            }
        });
    }
}
