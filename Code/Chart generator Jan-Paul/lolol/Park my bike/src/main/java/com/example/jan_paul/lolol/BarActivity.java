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
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Design_Patterns.Adapted_List;
import Design_Patterns.IOptionVisitor;
import Design_Patterns.Option;
import Design_Patterns.OptionVisitor;

public class BarActivity extends AppCompatActivity {
    public DatabaseAccess databaseAccess;
    public IOptionVisitor<Data, Data> the_visitor = new OptionVisitor<Data>();
    public IOptionVisitor<Data2, Data2> the_visitor2 = new OptionVisitor<Data2>();

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
        chart.animateY(2000);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        ArrayList<String> xVals = new ArrayList<String>();

        if (id == 2131558583) {
            chart.setDescription("5 neigbourhoods with most fietstrommels");
            List<Data> dataaa;
            dataaa = databaseAccess.getMostfietstrommels();
            databaseAccess.close();
            int counter = 0;
            Adapted_List<Data> adaptedlist = new Adapted_List(dataaa);
            Option<Data> thenewsome  = adaptedlist.GetNext();
            while (thenewsome.IsSome() == true) {
                try {
                    Data d = thenewsome.Visit(the_visitor);
                    ArrayList<BarEntry> a = new ArrayList<BarEntry>();
                    a.add(new BarEntry(d.value, 0));
                    BarDataSet s = new BarDataSet(a, d.naam);
                    s.setAxisDependency(YAxis.AxisDependency.LEFT);
                    ArrayList<Integer> colors = new ArrayList<Integer>();
                    for (int c : ColorTemplate.VORDIPLOM_COLORS)
                        colors.add(c);
                    s.setColor(colors.get(counter));
                    dataSets.add(s);
                    thenewsome = adaptedlist.GetNext();
                }
                catch (Exception e){}
                counter = counter + 1;
            }


        }
        else if (id == 2131558587){
            chart.setDescription("Most stolen bikes + amount of fietscontainers");
            List<Data2> dataaa;
            dataaa = databaseAccess.getMostStolenAndContainers();
            databaseAccess.close();
            int counter = 0;
            Adapted_List<Data2> adaptedlist = new Adapted_List(dataaa);
            Option<Data2> thenewsome  = adaptedlist.GetNext();
            while (thenewsome.IsSome() == true) {
                try {
                    Data2 d = thenewsome.Visit(the_visitor2);
                    ArrayList<BarEntry> a1 = new ArrayList<BarEntry>();
                    ArrayList<BarEntry> a2 = new ArrayList<BarEntry>();
                    a1.add(new BarEntry(d.value1, 0));
                    a2.add(new BarEntry(d.value2, 0));
                    BarDataSet s1 = new BarDataSet(a1, d.naam);
                    BarDataSet s2 = new BarDataSet(a2, "");
                    s1.setAxisDependency(YAxis.AxisDependency.LEFT);
                    ArrayList<Integer> colors = new ArrayList<Integer>();
                    for (int c : ColorTemplate.VORDIPLOM_COLORS)
                        colors.add(c);
                    s1.setColor(colors.get(1));
                    s2.setColor(colors.get(3));
                    dataSets.add(s1);
                    dataSets.add(s2);
                    thenewsome = adaptedlist.GetNext();
                }
                catch (Exception e){}
                counter = counter + 1;
            }
        }

        else{
            chart.setDescription("error, wrong button id: " + Integer.toString(id));
        }
        xVals.add("");
        BarData data = new BarData(xVals, dataSets);
        chart.setData(data);
        chart.invalidate();
    }
}
