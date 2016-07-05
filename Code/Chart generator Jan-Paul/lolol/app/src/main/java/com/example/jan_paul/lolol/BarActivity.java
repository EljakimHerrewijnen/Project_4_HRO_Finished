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

//import Design_Patterns.*;

public class BarActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_chart);

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

        BarChart chart = (BarChart) findViewById(R.id.barchart);
        chart.animateY(3000); //animatie van 3 secs
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        ArrayList<String> xVals = new ArrayList<String>();

        if (id == 2131493014) {
            List<Data> dataaa;
            dataaa = databaseAccess.getMostfietstrommels();
            databaseAccess.close();
            int counter = 0;
            for(Iterator<Data> i = dataaa.iterator(); i.hasNext(); ) {
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
        }
        else if (id == 2131493018){
            List<Data2> dataaa;
            dataaa = databaseAccess.getMostStolenAndContainers();
            databaseAccess.close();
            int counter = 0;
            for(Iterator<Data2> i = dataaa.iterator(); i.hasNext(); ) {
                Data2 d = i.next();
                ArrayList<BarEntry> a1 = new ArrayList<BarEntry>();
                ArrayList<BarEntry> a2 = new ArrayList<BarEntry>();
                a1.add(new BarEntry(d.value1, 0));
                a2.add(new BarEntry(d.value2, 0));
                BarDataSet s1 = new BarDataSet(a1, d.naam);
                BarDataSet s2 = new BarDataSet(a2, d.naam);
                s1.setAxisDependency(YAxis.AxisDependency.LEFT);
                ArrayList<Integer> colors = new ArrayList<Integer>();
                for (int c : ColorTemplate.VORDIPLOM_COLORS)
                    colors.add(c);
                s1.setColor(colors.get(1));
                s2.setColor(colors.get(3));
                counter = counter + 1;
                dataSets.add(s1);
                dataSets.add(s2);
            }
        }
        xVals.add("");
        BarData data = new BarData(xVals, dataSets);
        chart.setData(data);
        chart.setDescription(Integer.toString(id));
        chart.invalidate();
    }
}
