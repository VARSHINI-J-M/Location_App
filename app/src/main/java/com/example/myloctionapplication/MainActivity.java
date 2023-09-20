package com.example.myloctionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager lm=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria c=new Criteria();
        String s=lm.getBestProvider(c,false);
        if(s!=null && !s.equals("")) {
            @SuppressLint("MissingPermission")
            Location l = lm.getLastKnownLocation(s);
            lm.requestLocationUpdates(s, 20000, 1, this);
            if (l != null) {
                onLocationChanged(l);
            } else {
                Toast.makeText(getApplicationContext(), "Location can't be retrieved..!", Toast.LENGTH_LONG).show();
            }
        }
        else{
                Toast.makeText(getApplicationContext(), "Provider not found", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onLocationChanged(Location arg0)
        {
            TextView t1=(TextView) findViewById(R.id.lati);
            t1.setText("Latitude : \n"+arg0.getLatitude());
            TextView t2=(TextView) findViewById(R.id.longi);
            t2.setText("Longitude : \n"+arg0.getLongitude());
        }
        public void onProviderDisabled(String arg0)
        {

        }
        @Override
                public void onProviderEnabled(String arg0)
        {

        }
        @Override
    public void onStatusChanged(String arg0,int arg1,Bundle arg2)
        {

        }
    }
