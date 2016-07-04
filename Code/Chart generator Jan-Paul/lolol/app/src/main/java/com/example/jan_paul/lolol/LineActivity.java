package com.example.jan_paul.lolol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_chart);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        loadChart(MainActivity.id);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void loadChart(int id){
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        List<Data> dataaa;
        if (id == 2131493015) {
            dataaa = databaseAccess.getMostStolenBrands();
        }
        else if (id == 2131493016){
            dataaa = databaseAccess.getMostStolenColors();
        }
        else {
            //this will never happen but whatever
            dataaa = databaseAccess.getBicycleTheftPerMonth();
        }
        databaseAccess.close();

        LineChart chart = (LineChart) findViewById(R.id.linechart);
        ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
        ArrayList<String> xVals = new ArrayList<String>();
        int counter = 0;
        for(Iterator<Data> i = dataaa.iterator(); i.hasNext(); ) {
            Data d = i.next();
            valsComp1.add(new Entry(d.value, counter));
            counter = counter + 1;
            xVals.add(d.naam);
        }

        LineDataSet setComp1 = new LineDataSet(valsComp1, "bicycles stolen");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);
        float max = counter; //highest y value
        float min = 0; //lowest x value

        LineData data = new LineData(xVals, dataSets);
        chart.animateX(2000); //animatie van 3 secs
        chart.setData(data);
        chart.invalidate();
    }
}
