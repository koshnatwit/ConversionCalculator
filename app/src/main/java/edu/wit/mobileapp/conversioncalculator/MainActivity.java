package edu.wit.mobileapp.conversioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "myApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Bitmap imgTime = BitmapFactory.decodeResource(getResources(), R.drawable.time_icon);

        List<GridItem> list = new ArrayList<GridItem>();

        GridItem item1 = new GridItem();
        item1.image = null;
        item1.title = "Distance";
        list.add(item1);

        GridItem item2 = new GridItem();
        item2.image = imgTime;
        item2.title = "Time";
        list.add(item2);

        GridItem item3 = new GridItem();
        item3.image = null;
        item3.title = "Mass";
        list.add(item3);

        GridItem item4 = new GridItem();
        item4.image = null;
        item4.title = "Temperature";
        list.add(item4);

        GridItem item5 = new GridItem();
        item5.image = null;
        item5.title = "Velocity";
        list.add(item5);

        GridItem item6 = new GridItem();
        item6.image = null;
        item6.title = "Angle";
        list.add(item6);

        GridItemAdapter adapter;
        adapter = new GridItemAdapter(this, 0, list);

        GridView gridview = (GridView) findViewById(R.id.GridView01);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                if (position == 0) {
                    Log.v("myApp", "distance clicked");
                    intent.setClass(MainActivity.this, DistanceActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Log.v("myApp", "time clicked");
                    intent.setClass(MainActivity.this, TimeActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Log.v("myApp", "mass clicked");
                    intent.setClass(MainActivity.this, MassActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Log.v("myApp", "temp clicked");
                    intent.setClass(MainActivity.this, TempActivity.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Log.v("myApp", "velocity clicked");
                    intent.setClass(MainActivity.this, SpeedActivity.class);
                    startActivity(intent);
                }
                if (position == 5) {
                    Log.v("myApp", "angle clicked");
                    intent.setClass(MainActivity.this, AngleActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
