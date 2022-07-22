package edu.wit.mobileapp.conversioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DistanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        EditText enterField = (EditText) findViewById(R.id.editTextNumberDecimal);
        TextView resultField = (TextView) findViewById(R.id.editTextNumberDecimal2);

        Button clear = (Button) findViewById(R.id.clear_text);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enterField.setText("");
                resultField.setText("");
            }
        });
    }
}
