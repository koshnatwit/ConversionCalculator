package edu.wit.mobileapp.conversioncalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "myApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Bitmap imgTime = BitmapFactory.decodeResource(getResources(), R.drawable.time_icon);
        Bitmap imgDist = BitmapFactory.decodeResource(getResources(), R.drawable.distance_icon);
        Bitmap imgMass = BitmapFactory.decodeResource(getResources(), R.drawable.mass_icon);
        Bitmap imgTemp = BitmapFactory.decodeResource(getResources(), R.drawable.temp_icon);
        Bitmap imgSpeed = BitmapFactory.decodeResource(getResources(), R.drawable.speed_icon);
        Bitmap imgAngle = BitmapFactory.decodeResource(getResources(), R.drawable.angle_icon);

        List<GridItem> list = new ArrayList<GridItem>();

        GridItem item1 = new GridItem();
        item1.image = imgDist;
        item1.title = "Distance";
        list.add(item1);

        GridItem item2 = new GridItem();
        item2.image = imgTime;
        item2.title = "Time";
        list.add(item2);

        GridItem item3 = new GridItem();
        item3.image = imgMass;
        item3.title = "Mass";
        list.add(item3);

        GridItem item4 = new GridItem();
        item4.image = imgTemp;
        item4.title = "Temperature";
        list.add(item4);

        GridItem item5 = new GridItem();
        item5.image = imgSpeed;
        item5.title = "Velocity";
        list.add(item5);

        GridItem item6 = new GridItem();
        item6.image = imgAngle;
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

        /*
        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.NavigationView);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = new Intent();
                switch (item.getItemId()) {
                    case R.id.favorites :
                        intent.setClass(MainActivity.this, FavoritesActivity.class); // rename class to whatever we name it
                        startActivity(intent);
                        return true;
                    case R.id.settings :
                        intent.setClass(MainActivity.this, SettingsActivity.class); // rename class to whatever we name it
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
        */
    }
}
