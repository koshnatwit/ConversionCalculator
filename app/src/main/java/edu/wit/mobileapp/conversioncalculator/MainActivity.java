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
        //hi testing

        setContentView(R.layout.activity_main);
        String test = null;

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);

        Bitmap defaultImage;
        defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.default_image);

        List<GridItem> list = new ArrayList<GridItem>();

        GridItem item1 = new GridItem();
        item1.image = defaultImage;
        item1.title = "Title-1";
        item1.date = date;
        list.add(item1);

        GridItem item2 = new GridItem();
        item2.image = defaultImage;
        item2.title = "Title-2";
        item2.date = date;
        list.add(item2);

        GridItem item3 = new GridItem();
        item3.image = defaultImage;
        item3.title = "Title-3";
        item3.date = date;
        list.add(item3);

        GridItem item4 = new GridItem();
        item4.image = defaultImage;
        item4.title = "Title-4";
        item4.date = date;
        list.add(item4);

        GridItem item5 = new GridItem();
        item5.image = defaultImage;
        item5.title = "Title-5";
        item5.date = date;
        list.add(item5);

        GridItem item6 = new GridItem();
        item6.image = defaultImage;
        item6.title = "Title-6";
        item6.date = date;
        list.add(item6);

        GridItemAdapter adapter;
        adapter = new GridItemAdapter(this, 0, list);

        GridView gridview = (GridView) findViewById(R.id.GridView01);
        gridview.setAdapter(adapter);

    }
}