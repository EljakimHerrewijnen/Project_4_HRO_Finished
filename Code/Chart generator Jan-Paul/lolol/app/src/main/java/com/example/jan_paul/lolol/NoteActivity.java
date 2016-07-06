package com.example.jan_paul.lolol;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Joostdw1 on 6-7-2016.
 */
public class NoteActivity extends AppCompatActivity {

    Button save_btn, read_btn, delete_btn;
    TextView data_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        save_btn = (Button) findViewById(R.id.btn_save);
        read_btn = (Button) findViewById(R.id.btn_read);
        delete_btn = (Button) findViewById(R.id.btn_delete);
        data_tv = (TextView) findViewById(R.id.tv_data);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                SQLiteDatabase database = databaseAccess.getdatabase();
                Cursor cursor = database.rawQuery("INSERT INTO location (land, stad, postcode, straat, huisnr, x_coordinaat, y_coordinaat) " +
                                                "VALUES ('Nederland', 'Rotterdam', '2645OK', 'Wijnhaven', '107a', 0.0, 1.0) ", null);
                cursor.close();
                databaseAccess.close();
            }
        });

        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                SQLiteDatabase database = databaseAccess.getdatabase();
                Cursor cursor = database.rawQuery("SELECT land, stad, postcode, straat, huisnr, x_coordinaat, y_coordinaat " +
                        "FROM location " +
                        "WHERE id = (SELECT MAX(id) FROM location)", null);
                cursor.moveToFirst();
                String land = "l";
                String stad = "s";
                String postcode = "p";
                String straat = "s";
                String huisnr = "h";
                String x_coordinaat = "x";
                String y_coordinaat = "y";
                while (!cursor.isAfterLast()) {
                    land = cursor.getString(0);
                    stad = cursor.getString(1);
                    postcode = cursor.getString(2);
                    straat = cursor.getString(3);
                    huisnr = cursor.getString(4);
                    x_coordinaat = cursor.getString(5);
                    y_coordinaat = cursor.getString(6);
                    cursor.moveToNext();
                }
                cursor.close();
                databaseAccess.close();
                data_tv.setText(land + " " + stad + " " + postcode + " " + straat + " " + huisnr + " " + x_coordinaat + " " + y_coordinaat);
            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                SQLiteDatabase database = databaseAccess.getdatabase();
                Cursor cursor = database.rawQuery("DELETE FROM location", null);
                cursor.close();
                databaseAccess.close();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


}
