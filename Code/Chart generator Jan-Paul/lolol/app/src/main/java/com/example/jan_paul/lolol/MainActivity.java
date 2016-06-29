package com.example.jan_paul.lolol;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Switch;
import android.widget.Toast;
import android.database.sqlite.*;
import android.content.Context;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;
    public boolean pie;
    public boolean line;
    Context content;

    Button btnLoadData;
    EditText editTxtData;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        btnLoadData =(Button)findViewById(R.id.btn_database);
        editTxtData = (EditText)findViewById(R.id.editTextData);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new com.example.jan_paul.lolol.CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
              //  Toast.makeText(getApplicationContext(),
                //        expandableListTitle.get(groupPosition) + " List Expanded."
                 //       Toast.LENGTH_SHORT).show();
                //Above is for displaying text.
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                //Toast.makeText(getApplicationContext(),
                  //      expandableListTitle.get(groupPosition) + " List Collapsed."
                    //    Toast.LENGTH_SHORT).show();
                //Above is for displaying text

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

        btnLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                String deelgemeente = databaseAccess.getDeelgemeente2();
                databaseAccess.close();
                editTxtData.setText(editTxtData.getText() + deelgemeente);
            }
        });
    }

    //gets called when something is toggled in main activity
    public void onToggle(View v){
        //checks what is toggled, and gets its boollean value.
        Switch s = (Switch) v;
        if (s.isChecked() == true){
            //if(s.getId() == 2){

            //}
        }
        else{

        }

    }


    //opens chart activity
    public void onGenerate(View v){
        startActivity(new Intent(MainActivity.this, ChartActivity.class));
    }

}
