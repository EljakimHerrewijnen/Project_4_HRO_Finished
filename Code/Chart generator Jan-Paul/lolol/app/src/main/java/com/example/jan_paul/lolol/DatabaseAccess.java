package com.example.jan_paul.lolol;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Joostdw1 on 28-6-2016.
 */
public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all deelgemeentes from the database.
     *
     * @return a List of deelgemeentes
     */
    public List<String> getDeelgemeente1() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT deelgemeente FROM fietstrommels", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String getMostDeelgemeente2() {
        String most_deelgemeente = " ";
        String aantal_deelgemeente = " ";
        Cursor cursor = database.rawQuery("SELECT deelgemeente, COUNT(*) AS 'aantal' FROM fietstrommels GROUP BY deelgemeente ORDER BY aantal DESC limit 5", null);
        //query(fietstrommels, new String<>, )
        //("SELECT deelgemeente FROM fietstrommels", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            most_deelgemeente = cursor.getString(0);
            aantal_deelgemeente = cursor.getString(1);
            cursor.moveToNext();
        }
        cursor.close();

        String returning_string = most_deelgemeente + " " + aantal_deelgemeente;

        return returning_string;
    }

    public List<Data> getMostfietstrommels() {
        //HashMap<String, Integer> data = new HashMap<String, Integer>();
        //HashMap<>
        //List<String> most_deelgemeente = new ArrayList<>();
        //List<int> aantal_fietstrommels = new ArrayList<>();
        List<Data> mostfietstrommels_list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT deelgemeente, COUNT(*) AS 'aantal' FROM fietstrommels GROUP BY deelgemeente ORDER BY aantal DESC limit 5", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String most_deelgemeente = cursor.getString(0);
            int aantal_fietstrommels = Integer.parseInt(cursor.getString(1));
            mostfietstrommels_list.add(new Data(most_deelgemeente, aantal_fietstrommels));
            cursor.moveToNext();
        }
        cursor.close();

        return mostfietstrommels_list;
    }

}