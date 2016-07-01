package com.example.jan_paul.lolol;

import android.content.Intent;
import android.icu.util.Calendar;
import android.content.Context;

/**
 * Created by Eljakim Herrewijnen on 30-6-2016.
 */
public class Location_ToCalendar {
    public static Location_ToCalendar setLocation(){
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", cal.getTimeInMillis());
        intent.putExtra("allDay", true);
        intent.putExtra("rrule", "FREQ=YEARLY");
        intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
        intent.putExtra("title", "A Test Event from android app");
        //startActivity(intent);
        return null;
    }
}
