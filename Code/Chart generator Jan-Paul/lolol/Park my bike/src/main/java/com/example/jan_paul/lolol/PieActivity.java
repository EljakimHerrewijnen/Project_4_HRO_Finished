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

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;
import java.util.List;

import Design_Patterns.*;

public class PieActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;
    public IOptionVisitor<Data, Data> the_visitor = new OptionVisitor<Data>();

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
        PieChart chart = (PieChart) findViewById(R.id.piechart);
        databaseAccess.open();
        List<Data> dataaa;
        if (id == 2131493025) {
            dataaa = databaseAccess.getMostStolenBrands();
            chart.setDescription("Most stolen brands");
        }
        else if (id == 2131493026){
            dataaa = databaseAccess.getMostStolenColors();
            chart.setDescription("Most stolen colors");
        }
        else {
            //this will never happen but whatever
            dataaa = databaseAccess.getMostfietstrommels();
            chart.setDescription(Integer.toString(id));
        }

        databaseAccess.close();
        chart.animateX(2000); //animatie van 3 secs
        ArrayList<String> xVals = new ArrayList<String>();
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        int counter = 0; // maximum brands that show up in the pie chart
        Adapted_List<Data> adaptedlist = new Adapted_List(dataaa);
        Option<Data> thenewsome  = adaptedlist.GetNext();
        while (thenewsome.IsSome() == true && counter < 10) {
            try {
                Data d = thenewsome.Visit(the_visitor);
                yVals.add(new Entry(d.value, counter));
                xVals.add(d.naam);
                thenewsome = adaptedlist.GetNext();
            }
            catch (Exception e){}
            counter = counter + 1;
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
        chart.invalidate();
    }
}
