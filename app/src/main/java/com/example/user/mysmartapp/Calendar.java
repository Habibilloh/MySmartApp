package com.example.user.mysmartapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class Calendar extends AppCompatActivity {
    CalendarView calendarView;
    TextView text;
    Button pop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView=(CalendarView)findViewById(R.id.calendar);
        text=(TextView)findViewById(R.id.ur_date);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                String date= (i1+1)+"/"+i2+"/"+i;
                text.setText(date);
            }
        });
        pop=(Button)findViewById(R.id.popup);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Calendar.this, "Saved!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
