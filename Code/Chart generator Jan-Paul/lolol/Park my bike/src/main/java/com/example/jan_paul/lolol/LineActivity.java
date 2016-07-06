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

import Design_Patterns.Adapted_List;
import Design_Patterns.IOptionVisitor;
import Design_Patterns.Option;
import Design_Patterns.OptionVisitor;

public class LineActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;
    public IOptionVisitor<Data, Data> the_visitor = new OptionVisitor<Data>();

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
        List<Data> olddataaa;
        olddataaa = databaseAccess.getBicycleTheftPerMonth();
        databaseAccess.close();
        FixMonthOrder fix = new FixMonthOrder();
        List<Data> dataaa = fix.FixMonth(olddataaa);

        LineChart chart = (LineChart) findViewById(R.id.linechart);
        chart.setDescription("Stolen bikes per month");
        ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
        ArrayList<String> xVals = new ArrayList<String>();
        int counter = 0;
        Adapted_List<Data> adaptedlist = new Adapted_List(dataaa);
        Option<Data> thenewsome  = adaptedlist.GetNext();
        while (thenewsome.IsSome() == true) {
            try {
                Data d = thenewsome.Visit(the_visitor);
                valsComp1.add(new Entry(d.value, counter));
                xVals.add(d.naam);
                thenewsome = adaptedlist.GetNext();
            }
            catch (Exception e){}
            counter = counter + 1;
        }

        LineDataSet setComp1 = new LineDataSet(valsComp1, "bicycles stolen");
        setComp1.setDrawFilled(true);
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);
        LineData data = new LineData(xVals, dataSets);
        chart.animateY(2000); //animatie van 3 secs
        chart.setData(data);
        chart.invalidate();
    }
}
