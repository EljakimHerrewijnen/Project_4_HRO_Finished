package com.example.jan_paul.lolol;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joostdw1 on 28-6-2016.
 */
public class DatabaseAccess {
    public SQLiteOpenHelper openHelper;
    public SQLiteDatabase database;
    public static DatabaseAccess instance;

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

    public List<Data> getMostStolenBrands() {
        List<Data> MostStolenBrands_list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Merk, COUNT(*) AS 'aantal' FROM fietsendiefstal GROUP BY Merk ORDER BY aantal DESC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String most_brands = cursor.getString(0);
            int aantal_fietsen = Integer.parseInt(cursor.getString(1));
            MostStolenBrands_list.add(new Data(most_brands, aantal_fietsen));
            cursor.moveToNext();
        }
        cursor.close();

        return MostStolenBrands_list;
    }

    public List<Data> getMostStolenColors() {
        List<Data> MostStolenColors_list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Kleur, COUNT(*) AS 'aantal' FROM fietsendiefstal GROUP BY Kleur ORDER BY aantal DESC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String most_colors = cursor.getString(0);
            int aantal_fietsen = Integer.parseInt(cursor.getString(1));
            MostStolenColors_list.add(new Data(most_colors, aantal_fietsen));
            cursor.moveToNext();
        }
        cursor.close();

        return MostStolenColors_list;
    }
    /*
    public List<Data> getMostStolenAndContainers() {
        List<Data> MostStolenAndContainers_list = new ArrayList<>();
        String deelgemeente = "";
        Cursor cursor = database.rawQuery("SELECT mutatiedatum, COUNT(*) AS 'aantal' FROM fietstrommels WHERE deelgemeente = ' ' GROUP BY mutatiedatum ORDER BY mutatiedatum ASC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String months = cursor.getString(0);
            int aantal_fietsen = Integer.parseInt(cursor.getString(1));
            int aantal_fietstrommels Integer.parseInt(cursor.getString(2));
            MostStolenAndContainers_list.add(new Data2(most_colors, aantal_fietsen, aantal_fietstrommels));
            cursor.moveToNext();
        }
        cursor.close();

        return MostStolenAndContainers_list;
    }
    */
    /*
    public List<Data> getBicycleTheftPerMonth() {
        List<Data> bicycleTheft_list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Kennisname, COUNT(*) AS 'aantal' FROM fietsendiefstal GROUP BY Kennisname HAVING aantal = '%-1-%' OR '%-2-%' OR '%-3-%'OR '%-4-%'OR '%-5-%'OR '%-6-%'OR '%-7-%'OR '%-8-%'OR '%-9-%'OR '%-10-%'OR '%-11-%'OR '%-12-%'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String months = cursor.getString(0);
            months = months.substring(2, 5);
            if (months == "-1-"){
                months = "Januari";
            }
            if (months == "-2-"){
                months = "Februari";
            }
            if (months == "-3-"){
                months = "Maart";
            }
            if (months == "-4-"){
                months = "April";
            }
            if (months == "-5-"){
                months = "Mei";
            }
            if (months == "-6-"){
                months = "Juni";
            }
            if (months == "-7-"){
                months = "Juli";
            }
            if (months == "-8-"){
                months = "Augustus";
            }
            if (months == "-9-"){
                months = "September";
            }
            if (months == "-10-"){
                months = "Oktober";
            }
            if (months == "-11-"){
                months = "November";
            }
            if (months == "-12-"){
                months = "December";
            }
            int aantal_gestolen_fietsen = Integer.parseInt(cursor.getString(1));
            bicycleTheft_list.add(new Data(months, aantal_gestolen_fietsen));
            cursor.moveToNext();
        }
        cursor.close();

        return bicycleTheft_list;
    }
    */
}