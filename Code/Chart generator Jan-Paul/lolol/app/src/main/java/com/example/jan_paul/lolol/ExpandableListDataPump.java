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

            List<String> Timo = new ArrayList<String>();
            Timo.add("XBOX");
            Timo.add("BF_One");
            Timo.add("The_Witcher");

            List<String> Joost = new ArrayList<String>();
            Joost.add("Trompet");
            Joost.add("Keyboard");
            Joost.add("Trombone");

            List<String> JanPeter = new ArrayList<String>();
            JanPeter.add("SSD");
            JanPeter.add("Portfolio");
            JanPeter.add("Laptophardeschijfcaddy");

            expandableListDetail.put("TIMO", Timo);
            expandableListDetail.put("JOOST", Joost);
            expandableListDetail.put("JANPETER", JanPeter);
            return expandableListDetail;

    }
}
