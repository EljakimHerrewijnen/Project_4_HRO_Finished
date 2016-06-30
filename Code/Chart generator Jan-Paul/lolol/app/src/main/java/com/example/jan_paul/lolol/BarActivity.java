package com.example.jan_paul.lolol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BarActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_chart);
        loadChart();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    //(String ChartType)
    public void loadChart(){
        //if (ChartType == "pie") {

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        List<Data> deelgemeente = databaseAccess.getMostfietstrommels();
        databaseAccess.close();


        BarChart chart = (BarChart) findViewById(R.id.barchart);
        int counter = 0;
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        ArrayList<String> xVals = new ArrayList<String>();

        for(Iterator<Data> i = deelgemeente.iterator(); i.hasNext(); ) {
            Data d = i.next();
            ArrayList<BarEntry> a = new ArrayList<BarEntry>();
            a.add(new BarEntry(d.value, counter));
            counter = counter + 1;
            BarDataSet s = new BarDataSet(a, d.naam);
            s.setAxisDependency(YAxis.AxisDependency.LEFT);
            dataSets.add(s);
            xVals.add(d.naam);


        }

        BarData data = new BarData(xVals, dataSets);
        //chart.animateX(3000); //animatie van 3 secs
        chart.setData(data);

        chart.invalidate();



        /*
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
        */

    }

   // }



}
