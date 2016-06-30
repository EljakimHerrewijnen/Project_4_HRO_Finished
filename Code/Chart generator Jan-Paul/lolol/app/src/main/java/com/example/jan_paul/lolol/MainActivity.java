package com.example.jan_paul.lolol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;

    //filters
    public static String ChartType = "";

    public String FilePath = "/data";
    public String FileName = "Fietsendiefstal";

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new com.example.jan_paul.lolol.CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
    }

    //opens chart activity
    public void onGenerate(View v){
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, ChartFragment.newInstance(), "rageComicList")
                .commit();
    }

    public void onToggle(View v){
        Switch s = (Switch) v;
        setFilter(s.getText().toString(), s.isChecked());
    }

    public void setFilter(String s, boolean b){
        if (s == "Pie chart" && b){ChartType = "pie";}
        if (s == "Pie chart" && !b){ChartType = "";}
        if (s == "Line chart" && b){ChartType = "line";}
        if (s == "Line chart" && !b){ChartType = "";}
    }
}
