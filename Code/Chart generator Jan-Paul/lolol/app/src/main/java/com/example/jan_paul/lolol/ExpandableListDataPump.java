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

            List<String> UserStorys = new ArrayList<String>();
            UserStorys.add("5 fietstrommels");
            UserStorys.add("x");
            UserStorys.add("y");

            List<String> ChartType = new ArrayList<String>();
            ChartType.add("Line chart");
            ChartType.add("Pie chart");

            expandableListDetail.put("UserStory", UserStorys);
            expandableListDetail.put("Charttype", ChartType);
            return expandableListDetail;

    }
}
