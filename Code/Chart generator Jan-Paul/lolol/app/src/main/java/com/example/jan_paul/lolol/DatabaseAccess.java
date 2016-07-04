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

    public List<Data> getMostfietstrommels() {          //barchart
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

    public List<Data> getMostStolenBrands() {           //piechart
        List<Data> MostStolenBrands_list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Merk, COUNT(*) AS 'aantal' FROM Fietsendiefstal GROUP BY Merk ORDER BY aantal DESC", null);
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

    public List<Data> getMostStolenColors() {           //piechart
        List<Data> MostStolenColors_list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Kleur, COUNT(*) AS 'aantal' FROM Fietsendiefstal GROUP BY Kleur ORDER BY aantal DESC", null);
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

    public List<Data> getBicycleTheftPerMonth() {           //linechart
        List<Data> bicycleTheft_list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT CASE WHEN Kennisname LIKE '%-1-%' THEN 'Januari' " +
                "WHEN Kennisname LIKE '%-2-%' THEN 'Februari' " +
                "WHEN Kennisname LIKE '%-3-%' THEN 'Maart' " +
                "WHEN Kennisname LIKE '%-4-%' THEN 'April' " +
                "WHEN Kennisname LIKE '%-5-%' THEN 'Mei' " +
                "WHEN Kennisname LIKE '%-6-%' THEN 'Juni' " +
                "WHEN Kennisname LIKE '%-7-%' THEN 'Juli' " +
                "WHEN Kennisname LIKE '%-8-%' THEN 'Augustus' " +
                "WHEN Kennisname LIKE '%-9-%' THEN 'September' " +
                "WHEN Kennisname LIKE '%-10-%' THEN 'Oktober' " +
                "WHEN Kennisname LIKE '%-11-%' THEN 'November' " +
                "WHEN Kennisname LIKE '%-12-%' THEN 'December' " +
                "ELSE NULL " +
                "END AS 'month', COUNT(*) AS 'aantal' " +
                "FROM fietsendiefstal " +
                "WHERE (Kennisname LIKE '%-1-%') OR (Kennisname LIKE '%-2-%') OR (Kennisname LIKE '%-3-%') OR (Kennisname LIKE '%-4-%') OR (Kennisname LIKE '%-5-%') OR (Kennisname LIKE '%-6-%') OR (Kennisname LIKE '%-7-%') OR (Kennisname LIKE '%-8-%') OR (Kennisname LIKE '%-9-%') OR (Kennisname LIKE '%-10-%') OR (Kennisname LIKE '%-11-%') OR (Kennisname LIKE '%-12-%') " +
                "GROUP BY CASE " +
                "WHEN Kennisname LIKE '%-1-%' THEN 'Januari' " +
                "WHEN Kennisname LIKE '%-2-%' THEN 'Februari' " +
                "WHEN Kennisname LIKE '%-3-%' THEN 'Maart' " +
                "WHEN Kennisname LIKE '%-4-%' THEN 'April' " +
                "WHEN Kennisname LIKE '%-5-%' THEN 'Mei' " +
                "WHEN Kennisname LIKE '%-6-%' THEN 'Juni' " +
                "WHEN Kennisname LIKE '%-7-%' THEN 'Juli' " +
                "WHEN Kennisname LIKE '%-8-%' THEN 'Augustus' " +
                "WHEN Kennisname LIKE '%-9-%' THEN 'September' " +
                "WHEN Kennisname LIKE '%-10-%' THEN 'Oktober' " +
                "WHEN Kennisname LIKE '%-11-%' THEN 'November' " +
                "WHEN Kennisname LIKE '%-12-%' THEN 'December' " +
                "ELSE NULL END", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String months = cursor.getString(0);
            int aantal_gestolen_fietsen = Integer.parseInt(cursor.getString(1));
            bicycleTheft_list.add(new Data(months, aantal_gestolen_fietsen));
            cursor.moveToNext();
        }
        cursor.close();

        return bicycleTheft_list;
    }


    public List<Data2> getMostStolenAndContainers() {       //grouped_barchart
        List<Data2> MostStolenAndContainers_list = new ArrayList<>();
        String deelgemeente = "";
        Cursor cursor = database.rawQuery("SELECT " +
                "CASE " +
                "WHEN Kennisname LIKE '%-1-%' THEN 'Januari' " +
                "WHEN Kennisname LIKE '%-2-%' THEN 'Februari' " +
                "WHEN Kennisname LIKE '%-3-%' THEN 'Maart' " +
                "WHEN Kennisname LIKE '%-4-%' THEN 'April' " +
                "WHEN Kennisname LIKE '%-5-%' THEN 'Mei' " +
                "WHEN Kennisname LIKE '%-6-%' THEN 'Juni' " +
                "WHEN Kennisname LIKE '%-7-%' THEN 'Juli' " +
                "WHEN Kennisname LIKE '%-8-%' THEN 'Augustus' " +
                "WHEN Kennisname LIKE '%-9-%' THEN 'September' " +
                "WHEN Kennisname LIKE '%-10-%' THEN 'Oktober' " +
                "WHEN Kennisname LIKE '%-11-%' THEN 'November' " +
                "WHEN Kennisname LIKE '%-12-%' THEN 'December' " +
                "ELSE NULL " +
                "END AS 'month', COUNT(*) AS 'aantal' " +
                "FROM Fietsendiefstal " +
                "WHERE (Kennisname LIKE '%-1-%') OR (Kennisname LIKE '%-2-%') OR (Kennisname LIKE '%-3-%') OR (Kennisname LIKE '%-4-%') OR (Kennisname LIKE '%-5-%') OR (Kennisname LIKE '%-6-%') OR (Kennisname LIKE '%-7-%') OR (Kennisname LIKE '%-8-%') OR (Kennisname LIKE '%-9-%') OR (Kennisname LIKE '%-10-%') OR (Kennisname LIKE '%-11-%') OR (Kennisname LIKE '%-12-%') " +
                "GROUP BY " +
                "CASE " +
                "WHEN Kennisname LIKE '%-1-%' THEN 'Januari' " +
                "WHEN Kennisname LIKE '%-2-%' THEN 'Februari' " +
                "WHEN Kennisname LIKE '%-3-%' THEN 'Maart' " +
                "WHEN Kennisname LIKE '%-4-%' THEN 'April' " +
                "WHEN Kennisname LIKE '%-5-%' THEN 'Mei' " +
                "WHEN Kennisname LIKE '%-6-%' THEN 'Juni' " +
                "WHEN Kennisname LIKE '%-7-%' THEN 'Juli' " +
                "WHEN Kennisname LIKE '%-8-%' THEN 'Augustus' " +
                "WHEN Kennisname LIKE '%-9-%' THEN 'September' " +
                "WHEN Kennisname LIKE '%-10-%' THEN 'Oktober' " +
                "WHEN Kennisname LIKE '%-11-%' THEN 'November' " +
                "WHEN Kennisname LIKE '%-12-%' THEN 'December' " +
                "ELSE NULL " +
                "END " +
                "UNION " +
                "SELECT " +
                "CASE " +
                "WHEN mutatiedatum LIKE '%-1-%' THEN 'Januari' " +
                "WHEN mutatiedatum LIKE '%-2-%' THEN 'Februari' " +
                "WHEN mutatiedatum LIKE '%-3-%' THEN 'Maart' " +
                "WHEN mutatiedatum LIKE '%-4-%' THEN 'April' " +
                "WHEN mutatiedatum LIKE '%-5-%' THEN 'Mei' " +
                "WHEN mutatiedatum LIKE '%-6-%' THEN 'Juni' " +
                "WHEN mutatiedatum LIKE '%-7-%' THEN 'Juli' " +
                "WHEN mutatiedatum LIKE '%-8-%' THEN 'Augustus' " +
                "WHEN mutatiedatum LIKE '%-9-%' THEN 'September' " +
                "WHEN mutatiedatum LIKE '%-10-%' THEN 'Oktober' " +
                "WHEN mutatiedatum LIKE '%-11-%' THEN 'November' " +
                "WHEN mutatiedatum LIKE '%-12-%' THEN 'December' " +
                "ELSE NULL " +
                "END AS 'month2', COUNT(*) AS 'aantal2' " +
                "FROM fietstrommels " +
                "WHERE (mutatiedatum LIKE '%-1-%') OR (mutatiedatum LIKE '%-2-%') OR (mutatiedatum LIKE '%-3-%') OR (mutatiedatum LIKE '%-4-%') OR (mutatiedatum LIKE '%-5-%') OR (mutatiedatum LIKE '%-6-%') OR (mutatiedatum LIKE '%-7-%') OR (mutatiedatum LIKE '%-8-%') OR (mutatiedatum LIKE '%-9-%') OR (mutatiedatum LIKE '%-10-%') OR (mutatiedatum LIKE '%-11-%') OR (mutatiedatum LIKE '%-12-%') " +
                "GROUP BY " +
                "CASE " +
                "WHEN mutatiedatum LIKE '%-1-%' THEN 'Januari'  " +
                "WHEN mutatiedatum LIKE '%-2-%' THEN 'Februari' " +
                "WHEN mutatiedatum LIKE '%-3-%' THEN 'Maart' " +
                "WHEN mutatiedatum LIKE '%-4-%' THEN 'April' " +
                "WHEN mutatiedatum LIKE '%-5-%' THEN 'Mei' " +
                "WHEN mutatiedatum LIKE '%-6-%' THEN 'Juni' " +
                "WHEN mutatiedatum LIKE '%-7-%' THEN 'Juli' " +
                "WHEN mutatiedatum LIKE '%-8-%' THEN 'Augustus' " +
                "WHEN mutatiedatum LIKE '%-9-%' THEN 'September' " +
                "WHEN mutatiedatum LIKE '%-10-%' THEN 'Oktober' " +
                "WHEN mutatiedatum LIKE '%-11-%' THEN 'November' " +
                "WHEN mutatiedatum LIKE '%-12-%' THEN 'December' " +
                "ELSE NULL " +
                "END ", null);
        cursor.moveToFirst();
        int k = 0;
        String months = "";
        int aantal_fietsen = 0;
        int aantal_fietstrommels = 0;
        while (!cursor.isAfterLast()) {
            k = k + 1;
            if (k == 1){
                months = cursor.getString(0);
                aantal_fietsen = Integer.parseInt(cursor.getString(1));
            }
            if (k == 2){
                aantal_fietstrommels = Integer.parseInt(cursor.getString(2));
                MostStolenAndContainers_list.add(new Data2(months, aantal_fietsen, aantal_fietstrommels));
                k = 0;
            }
            cursor.moveToNext();
        }
        cursor.close();

        return MostStolenAndContainers_list;
        }


}


//select month
/*months = months.substring(2, 5);
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
            }*/