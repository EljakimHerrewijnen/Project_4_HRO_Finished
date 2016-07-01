package com.example.jan_paul.lolol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PieActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_chart);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        loadChart();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    //(String ChartType)
    public void loadChart(){
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        List<Data> deelgemeente = databaseAccess.getMostStolenBrands();
        databaseAccess.close();
        PieChart chart = (PieChart) findViewById(R.id.piechart);
        //chart.animateX(3000); //animatie van 3 secs
        ArrayList<String> xVals = new ArrayList<String>();
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        int counter = 0;
        for(Iterator<Data> i = deelgemeente.iterator(); i.hasNext(); ) {
            Data d = i.next();
            yVals.add(new Entry(d.value, counter));
            counter = counter + 1;
            //s.setBarSpacePercent(20f);
            xVals.add("x");

        }

        PieDataSet dataSets = new PieDataSet(yVals, "top kek");

        PieData data = new PieData(xVals, dataSets);

        chart.setData(data);
        chart.setDescription("brands");
        chart.invalidate();
    }
}
