package com.example.user.mysmartapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine, add, mul, sub, div, equal, clear;
    private TextView tv, tv2;
    private double val1=0, val2=0, result;
    private String Vals[]= new String[2];
    private  char SIGNS='f';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        selecter();

        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"1");

            }});
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"2");

            }});
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"3");

            }});
        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"4");

            }});
        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"5");

            }});
        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"6");

            }});
        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"7");


            }});
        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"8");


            }});
        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"9");

            }});
        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(tv.getText().toString()+"0");


            }});
        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SIGNS='-';

                tv.setText(tv.getText().toString()+"-");
            }});
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SIGNS='+';
                tv.setText(tv.getText().toString()+"+");
            }});
        mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SIGNS='*';
                tv.setText(tv.getText().toString()+"*");
            }});
        div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SIGNS='/';
                tv.setText(tv.getText().toString()+"/");
            }});
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(tv.getText().length()>0){
                    CharSequence deleteBybit = tv.getText().toString();
                    tv.setText(deleteBybit.subSequence(0, deleteBybit.length()-1));}

            }});
        equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(SIGNS=='+'){
                    Vals =tv.getText().toString().split("\\+");}
                else if(SIGNS=='-'){
                    Vals =tv.getText().toString().split("-");
                }else if(SIGNS=='*'){
                    Vals =tv.getText().toString().split("\\*");
                }else if(SIGNS=='/'){
                    Vals =tv.getText().toString().split("/");
                }else{
                    Vals[0]=tv.getText().toString();
                    Vals[1]="";}



                Compute();
                SIGNS='=';
                int holder=(int)result;
                if(result/holder!=1) {
                    tv.setText(Double.toString(result));
                }else {tv.setText(Integer.toString(holder));}
                Vals=null;
                Vals= new String[2];
                val1=0;
                val2=0;

            }});
    }
    public void selecter(){
        zero = (Button)findViewById(R.id.but0);
        one = (Button)findViewById(R.id.but1);
        two = (Button)findViewById(R.id.but2);
        three = (Button)findViewById(R.id.but3);
        four = (Button)findViewById(R.id.but4);
        five = (Button)findViewById(R.id.but5);
        six = (Button)findViewById(R.id.but6);
        seven = (Button)findViewById(R.id.but7);
        eight = (Button)findViewById(R.id.but8);
        nine = (Button)findViewById(R.id.but9);
        add = (Button)findViewById(R.id.butAdd);
        sub = (Button)findViewById(R.id.butSubt);
        mul = (Button)findViewById(R.id.butMult);
        div = (Button)findViewById(R.id.butDiv);
        equal = (Button)findViewById(R.id.butEqual);
        clear = (Button)findViewById(R.id.butC);
        tv = (TextView)findViewById(R.id.textView);

    }

    public void Compute(){
        val1=Double.parseDouble(Vals[0]);
        if(Vals[1]!=""){
            val2=Double.parseDouble(Vals[1]);}

        if(Vals[1]!="") {
            switch (SIGNS) {
                case '+': {
                    result = val1 + val2;
                    break;
                }
                case '-': {
                    result = val1 - val2;
                    break;
                }
                case '*': {
                    result = val1 * val2;
                    break;
                }
                case '/': {
                    result = val1 / val2;
                    break;}

            }
        }else{
            result=val1;
        }

    }
}
