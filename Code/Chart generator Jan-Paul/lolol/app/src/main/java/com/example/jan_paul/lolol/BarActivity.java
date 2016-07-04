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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BarActivity extends AppCompatActivity {
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

    public void loadChart(){
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        List<Data> deelgemeente = databaseAccess.getMostfietstrommels();
        databaseAccess.close();
        
        BarChart chart = (BarChart) findViewById(R.id.barchart);
        chart.animateX(3000); //animatie van 3 secs
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        ArrayList<String> xVals = new ArrayList<String>();
        int counter = 0;
        for(Iterator<Data> i = deelgemeente.iterator(); i.hasNext(); ) {
            Data d = i.next();
            ArrayList<BarEntry> a = new ArrayList<BarEntry>();
            a.add(new BarEntry(d.value, 0));
            BarDataSet s = new BarDataSet(a, d.naam);
            s.setAxisDependency(YAxis.AxisDependency.LEFT);
            ArrayList<Integer> colors = new ArrayList<Integer>();
            for (int c : ColorTemplate.VORDIPLOM_COLORS)
                colors.add(c);
            s.setColor(colors.get(counter));
            counter = counter + 1;
            dataSets.add(s);
        }
        xVals.add("");

        BarData data = new BarData(xVals, dataSets);
        chart.setData(data);
        chart.setDescription("");
        chart.invalidate();
    }
}
