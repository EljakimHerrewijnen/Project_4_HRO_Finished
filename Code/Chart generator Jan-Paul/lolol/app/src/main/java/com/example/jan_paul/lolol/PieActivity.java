package com.example.jan_paul.lolol;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PieActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pie_chart);

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
            dataaa = databaseAccess.getMostfietstrommels();
        }

        databaseAccess.close();
        PieChart chart = (PieChart) findViewById(R.id.piechart);
        chart.animateX(2000); //animatie van 3 secs
        ArrayList<String> xVals = new ArrayList<String>();
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        int counter = 8; // maximum brands that show up in the pie chart
        for(Iterator<Data> i = dataaa.iterator(); i.hasNext() && counter != 0; ) {
            Data d = i.next();
            yVals.add(new Entry(d.value, counter));
            counter = counter - 1;
            xVals.add(d.naam);
        }

        PieDataSet dataSets = new PieDataSet(yVals, "");

        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        dataSets.setColors(colors);
        PieData data = new PieData(xVals, dataSets);

        chart.setData(data);
        chart.setDescription("");
        chart.invalidate();
    }
}
