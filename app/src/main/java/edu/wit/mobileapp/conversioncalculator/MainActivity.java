package edu.wit.mobileapp.conversioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
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
        
        // put icon Bitmaps for each image button here
        //Bitmap imgTime = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

        List<GridItem> list = new ArrayList<GridItem>();

        GridItem item1 = new GridItem();
        item1.image = null;
        item1.title = "Title-1";
        list.add(item1);

        GridItem item2 = new GridItem();
        item2.image = null;
        item2.title = "Title-2";
        list.add(item2);

        GridItem item3 = new GridItem();
        item3.image = null;
        item3.title = "Title-3";
        list.add(item3);

        GridItem item4 = new GridItem();
        item4.image = null;
        item4.title = "Title-4";
        list.add(item4);

        GridItem item5 = new GridItem();
        item5.image = null;
        item5.title = "Title-5";
        list.add(item5);

        GridItem item6 = new GridItem();
        item6.image = null;
        item6.title = "Title-6";
        list.add(item6);

        GridItemAdapter adapter;
        adapter = new GridItemAdapter(this, 0, list);

        GridView gridview = (GridView) findViewById(R.id.GridView01);
        gridview.setAdapter(adapter);

    }
}
