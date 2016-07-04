package com.example.jan_paul.lolol;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Switch;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener  {

    public GoogleApiClient mGoogleApiClient = null;
    public Location mLastLocation = null;

    Button btnLoadData, mLatitudeText, mLongitudeText;

    //filters
    public static String ChartType = "";

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    public DatabaseAccess databaseAccess;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        btnLoadData =(Button)findViewById(R.id.btn_database);
        mLatitudeText = (Button) findViewById(R.id.buttonworldy);
        mLongitudeText = (Button) findViewById(R.id.buttonworldx);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new com.example.jan_paul.lolol.CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        //Notification
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.notification_icon);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, This is Android Notification Detail!");

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this)
                    .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    public void onToggle(View v){
        Switch s = (Switch) v;
        //passes the switch name and its state to the filter setup
        setFilter(s.getText().toString(), s.isChecked());
    }

    //
    public void setFilter(String s, boolean b){
        if (s == "Pie chart" && b){ChartType = "pie";}
        if (s == "Pie chart" && !b){ChartType = "";}
        if (s == "Line chart" && b){ChartType = "line";}
        if (s == "Line chart" && !b){ChartType = "";}
    }

    //opens chart activity
    public void onGenerate(View v){
        Intent intent = new Intent(this, BarActivity.class);
        startActivity(intent);
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
            mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
