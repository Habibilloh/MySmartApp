package com.example.user.mysmartapp;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Coordetect extends AppCompatActivity {
    TextView text;
    Geocoder coder;
    Button save_cor, go_map;
    public double listOfLat[]= new double[100];
    public double listOfLong[]= new double[100];

    public int listCounter=0;
//    TextView myLocationText;

    LocationListener aa = new LocationListener(){
        public void onLocationChanged(Location location){
            updateWithNewLocation(location);
        }
        public void onStatusChanged(String a, int b, Bundle c){}
        public void onProviderEnabled(String provider){}
        public void onProviderDisabled(String provider){}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordetect);

        String serviceString = Context.LOCATION_SERVICE;
        LocationManager locationManager;
        locationManager = (LocationManager)getSystemService(serviceString);
        List<Address> addresses = null;

        String provider = LocationManager.NETWORK_PROVIDER;
//        Location a = locationManager.getLastKnownLocation(provider);
        locationManager.requestLocationUpdates(provider, 0, 0, aa);
//        updateWithNewLocation(a);
//        coder = new Geocoder(this);
//        double lat=37;
//        double lng=126;
//        try{
//            addresses =   coder.getFromLocation(lat, lng, 5);
//        } catch(NumberFormatException e){}
//        catch (IOException e){}
//        myLocationText.setText(addresses.get(0).toString());



        text= (TextView)findViewById(R.id.myLocationText);
        save_cor=(Button)findViewById(R.id.save_coordinates);
        go_map=(Button)findViewById(R.id.go_to_map);

        go_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Coordetect.this, Go_Map.class);
                myIntent.putExtra("ListOfLat", listOfLat);
                myIntent.putExtra("ListOfLong", listOfLong);




                Coordetect.this.startActivity(myIntent);
            }
        });
    }
    private void updateWithNewLocation(final Location location) {
        TextView myLocationText;
        myLocationText = (TextView)findViewById(R.id.myLocationText);
        String latLongString = "No location found";
        if (location != null) {
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            save_cor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listOfLat[listCounter]=location.getLatitude();
                    listOfLong[listCounter]=location.getLongitude();
                    listCounter++;
                    Toast.makeText(Coordetect.this, text.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            latLongString = "Lat:" + lat + "\nLong:" + lng;

        }
        myLocationText.setText("Your Current Position is:\n" +
                latLongString);
    }
}
