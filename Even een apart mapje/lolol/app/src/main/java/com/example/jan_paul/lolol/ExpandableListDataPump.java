package com.example.jan_paul.lolol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Eljakim Herrewijnen on 24-6-2016.
 */
public class ExpandableListDataPump {
        public static HashMap<String, List<String>> getData() {
            HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
            //HashMap<String, List<Integer>> data = new HashMap<String, List<Integer>>();
            HashMap<Integer, String> data = new HashMap<Integer, String>();


            List<String> Timo = new ArrayList<String>();
            Timo.add("XBOX");
            Timo.add("BF_One");
            Timo.add("The_Witcher");

            List<String> Joost = new ArrayList<String>();
            Joost.add("Trompet");
            Joost.add("Keyboard");
            Joost.add("Trombone");

            List<String> ChartType = new ArrayList<String>();
            ChartType.add("Line chart");
            ChartType.add("Pie chart");

            expandableListDetail.put("TIMO", Timo);
            expandableListDetail.put("JOOST", Joost);
            expandableListDetail.put("Charttype", ChartType);
            return expandableListDetail;

    }
}
