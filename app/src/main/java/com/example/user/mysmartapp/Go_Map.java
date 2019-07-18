package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Go_Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double[] ListOfLat;
    private double  [] ListOfLong;
    private int size=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go__map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        ListOfLat = intent.getDoubleArrayExtra("ListOfLat");
        ListOfLong = intent.getDoubleArrayExtra("ListOfLong");

        for(int i=0; i<ListOfLong.length;  i++){
            if(ListOfLong[i]==0){
                size=size+(i-1);
                break;
            }

        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng korea = new LatLng(0,0);
        LatLng busan = new LatLng(ListOfLat[0],  ListOfLong[0]);
        mMap.addMarker(new MarkerOptions().position(busan).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("Point : 1"));
        for(int i=1; i<=size; i++){
            korea = new LatLng(ListOfLat[i-1],  ListOfLong[i-1]);
            busan = new LatLng(ListOfLat[i],  ListOfLong[i]);
            PolylineOptions aa = new PolylineOptions().add(korea).add(busan);
            mMap.addMarker(new MarkerOptions().position(busan).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("Point : "+(i+1)));
            mMap.addPolyline(aa);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(busan));
    }
}
