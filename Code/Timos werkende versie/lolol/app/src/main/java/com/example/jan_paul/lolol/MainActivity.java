package com.example.jan_paul.lolol;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
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
import java.util.List;
import java.util.HashMap;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;


public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener  {

    public GoogleApiClient mGoogleApiClient = null;
    public Location mLastLocation = null;

    Button btnLoadData, FindAdressButton;
    Button btnSaveCalendar;
    EditText editTxtData;
    Geocoder geocoder;
    TextView FoundAdressText, mLatitudeText, mLongitudeText;


    //filters
    public static String ChartType = "";

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        btnLoadData =(Button)findViewById(R.id.btn_database);
        //btnSaveCalendar = (Button)findViewById(R.id.buttonworldy);
        editTxtData = (EditText)findViewById(R.id.editTextData);
        mLatitudeText = (TextView) findViewById(R.id.buttonworldy);
        mLatitudeText.setText("GPS is off");
        mLongitudeText = (TextView) findViewById(R.id.buttonworldx);
        mLongitudeText.setText("GPS is off");

        FoundAdressText = (TextView) findViewById(R.id.show_adress);
        FoundAdressText.setText("");
        FindAdressButton = (Button) findViewById(R.id.findaddresss);
        FindAdressButton.setText("Find your own location");
        geocoder = new Geocoder(this);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new com.example.jan_paul.lolol.CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        btnLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                List<Data> deelgemeente = databaseAccess.getMostfietstrommels();
                databaseAccess.close();
                editTxtData.setText("dit moet weg");
            }
        });
     //   btnSaveCalendar.setOnClickListener(new View.OnClickListener(){
        //    @Override
          //  public void onClick(View vw){
       //         Location_ToCalendar location_toCalendar = Location_ToCalendar.setLocation();
          //  }
       // });

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this)
                    .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
                    .addApi(LocationServices.API)
                    .build();
        }


        FindAdressButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String strLat = mLatitudeText.getText().toString();
                String strLon = mLongitudeText.getText().toString();

                boolean parsable = true;
                Double lat = null, lon = null;

                try{
                    lat = Double.parseDouble(strLat);
                }catch (NumberFormatException ex){
                    parsable = false;
                    Toast.makeText(MainActivity.this,
                            "Latitude does not contain a parsable double",
                            Toast.LENGTH_LONG).show();
                }

                try{
                    lon = Double.parseDouble(strLon);
                }catch (NumberFormatException ex){
                    parsable = false;
                    Toast.makeText(MainActivity.this,
                            "Longitude does not contain a parsable double",
                            Toast.LENGTH_LONG).show();
                }

                if(parsable){
                    Toast.makeText(MainActivity.this,
                            "find " + lat + " : " + lon,
                            Toast.LENGTH_SHORT).show();

                    List<Address> geoResult = findGeocoder(lat, lon);



                    if(geoResult != null){
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
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_list_item_1, android.R.id.text1, geoStringResult);

                        FoundAdressText.setText(stringThisAddress);
                    }

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
        /*
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, ChartFragment.newInstance(), "rageComicList")
                .commit();
                */
        Intent intent = new Intent(this, ChartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitudeText.setText("Latitude is: "+ String.valueOf(mLastLocation.getLatitude()));
            mLongitudeText.setText("Longitude is: " + String.valueOf(mLastLocation.getLongitude()));
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
















}
