package com.example.jan_paul.lolol;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Switch;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.location.Address;
import android.location.Geocoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import Design_Patterns.*;


public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener  {

    public GoogleApiClient mGoogleApiClient;
    public Location mLastLocation = null;

    Button btnLoadData, FindAdressButton, SetCalenderNote;
    EditText editTxtData, begintijd, eindtijd, beschrijving;
    Geocoder geocoder;
    TextView FoundAdressText, mLatitudeText, mLongitudeText;
    String variableforadress = "null";
    IOptionVisitor<Double, Double> the_visitor = new OptionVisitor<Double>();


    //filters
    public static String ChartType = "";

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);


        mLatitudeText = (TextView) findViewById(R.id.buttonworldy);
        mLongitudeText = (TextView) findViewById(R.id.buttonworldx);

        begintijd = (EditText) findViewById(R.id.Begintijdinput);
        eindtijd = (EditText) findViewById(R.id.Eindtijdinput);
        beschrijving = (EditText) findViewById(R.id.Beschrijving);

        FoundAdressText = (TextView) findViewById(R.id.show_adress);
        FindAdressButton = (Button) findViewById(R.id.findaddresss);
        SetCalenderNote = (Button) findViewById(R.id.button3);


        geocoder = new Geocoder(this);




        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this)
                .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
                .addApi(LocationServices.API)
                .build();



        FindAdressButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String strLat = mLatitudeText.getText().toString();
                String strLon = mLongitudeText.getText().toString();

                boolean parsable = true;
                Option<Double> latpart1 = new None<Double>(), lonpart1 = new None<Double>();
                Double lat = 0.0, lon = 0.0;

                try{
                    latpart1 = new Some<Double>(Double.parseDouble(strLat));
                    try {
                        lat = latpart1.Visit(the_visitor);
                    }catch(Exception e){}

                    lonpart1 = new Some<Double>(Double.parseDouble(strLon));
                    try {
                        lon = lonpart1.Visit(the_visitor);
                    }catch(Exception e){}



                }catch (NumberFormatException ex){
                    parsable = false;
                    Toast.makeText(MainActivity.this,
                            "Does not contain parsable doubles",
                            Toast.LENGTH_LONG).show();
                }


                if(parsable){
                    Toast.makeText(MainActivity.this,
                            "find " + lat + " : " + lon,
                            Toast.LENGTH_SHORT).show();

                    List<Address> geoResult = findGeocoder(lat, lon);


                    List<String> geoStringResult = new ArrayList<String>();
                    String stringThisAddress = "";
                    for(int i=0; i < geoResult.size(); i++){
                        Address thisAddress = geoResult.get(i);

                        stringThisAddress +=
                                "CountryName: " + thisAddress.getCountryName() + "\n"
                                        + "CityName: " + thisAddress.getLocality() + "\n"
                                        + "PostalCode: " + thisAddress.getPostalCode() + "\n"
                                        + "AdressLine: " + thisAddress.getAddressLine(0);
                        geoStringResult.add(stringThisAddress);
                        variableforadress = thisAddress.getAddressLine(0);
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, android.R.id.text1, geoStringResult);

                    FoundAdressText.setText(stringThisAddress);

                }
            }
        });




    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
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



    private List<Address> findGeocoder(Double lat, Double lon){
        final int maxResults = 1;
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(lat, lon, maxResults);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return addresses;
    }





    public void Set_Calender_Note(View v) {


        if (variableforadress == "null"){
            Toast.makeText(MainActivity.this,
                    "First get your location",
                    Toast.LENGTH_LONG).show();
        }

        else {

            String textinputbegintijd, textinputeindtijd, textinputbeschrijving;


            if (begintijd.getText().toString() == "Begintijd" || begintijd.getText().toString().split(":").length != 5 ){
                textinputbegintijd = "2016:1:1:9:00";
            }

            else{
                textinputbegintijd = begintijd.getText().toString();
            }

            if (eindtijd.getText().toString() == "Eindtijd" || eindtijd.getText().toString().split(":").length != 5){
                textinputeindtijd = "2016:1:1:18:00";
            }

            else{
                textinputeindtijd = eindtijd.getText().toString();
            }

            if (beschrijving.getText().toString() == "Beschrijving"){
                textinputbeschrijving = "Left blank";
            }

            else {
                textinputbeschrijving = beschrijving.getText().toString();
            }

            String[] splittedbegintijd = textinputbegintijd.split(":");
            String[] splittedeindtijd = textinputeindtijd.split(":");

            int begintijdinyear = Integer.parseInt(splittedbegintijd[0]);
            int begintijdinmonths = Integer.parseInt(splittedbegintijd[1]);
            int begintijdindays = Integer.parseInt(splittedbegintijd[2]);
            int begintijdinhours = Integer.parseInt(splittedbegintijd[3]);
            int begintijdinminutes = Integer.parseInt(splittedbegintijd[4]);

            int eindtijdinyear = Integer.parseInt(splittedeindtijd[0]);
            int eindtijdinmonths = Integer.parseInt(splittedeindtijd[1]);
            int eindtijdindays = Integer.parseInt(splittedbegintijd[2]);
            int eindtijdinhours = Integer.parseInt(splittedbegintijd[3]);
            int eindtijdinminutes = Integer.parseInt(splittedbegintijd[4]);



            long calID = 3;
            long startMillis = 0;
            long endMillis = 0;
            Calendar beginTime = Calendar.getInstance();
            beginTime.set(begintijdinyear, begintijdinmonths - 1, begintijdindays, begintijdinhours, begintijdinminutes); // -1 for the right date
            startMillis = beginTime.getTimeInMillis();
            Calendar endTime = Calendar.getInstance();
            endTime.set(eindtijdinyear, eindtijdinmonths - 1, eindtijdindays, eindtijdinhours, eindtijdinminutes); // also here
            endMillis = endTime.getTimeInMillis();


            ContentResolver cr = getContentResolver();
            ContentValues values = new ContentValues();
            values.put(CalendarContract.Events.DTSTART, startMillis);
            values.put(CalendarContract.Events.DTEND, endMillis);
            values.put(CalendarContract.Events.TITLE, "I need to pick up my bike");
            values.put(CalendarContract.Events.DESCRIPTION, textinputbeschrijving);
            values.put(CalendarContract.Events.CALENDAR_ID, calID);
            values.put(CalendarContract.Events.EVENT_TIMEZONE, "America/Los_Angeles");
            values.put(CalendarContract.Events.EVENT_LOCATION, variableforadress);


            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);

            // get the event ID that is the last element in the Uri
            long eventID = Long.parseLong(uri.getLastPathSegment());

            Toast.makeText(this,
                    "Its pasted in your agenda",
                    Toast.LENGTH_LONG).show();
        }


    }


}







