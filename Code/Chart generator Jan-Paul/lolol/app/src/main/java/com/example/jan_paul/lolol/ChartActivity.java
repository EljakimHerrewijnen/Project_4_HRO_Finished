package com.example.jan_paul.lolol;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class ChartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        loadChart(MainActivity.ChartType);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public void loadChart(String ChartType){
        if (ChartType == "pie") {
            LineChart chart = (LineChart) findViewById(R.id.chart);

            ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
            ArrayList<Entry> valsComp2 = new ArrayList<Entry>();

            valsComp1.add(new Entry(100.000f, 0));
            valsComp1.add(new Entry(50.000f, 5));

            valsComp2.add(new Entry(130.000f, 0));
            valsComp2.add(new Entry(150.000f, 7));

            LineDataSet setComp1 = new LineDataSet(valsComp1, "A");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            LineDataSet setComp2 = new LineDataSet(valsComp2, "B");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(setComp1);
            dataSets.add(setComp2);

            float max = 7; //highest y value
            float min = -5; //lowest x value

            ArrayList<String> xVals = new ArrayList<String>();

            while (max >= min) {
                xVals.add(Float.toString(min));
                min = min + 1;
            }

            LineData data = new LineData(xVals, dataSets);
            //chart.animateX(3000); //animatie van 3 secs
            chart.setData(data);

            chart.invalidate();

        }

    }



}
