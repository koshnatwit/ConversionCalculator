package edu.wit.mobileapp.conversioncalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Time");

        Spinner spinnerTime1 = findViewById(R.id.spinner_time1);
        Spinner spinnerTime2 = findViewById(R.id.spinner_time2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Log.v("myApp", "time clicked");
        spinnerTime1.setAdapter(adapter);
        spinnerTime2.setAdapter(adapter);

        EditText enterField = (EditText) findViewById(R.id.editTextNumberDecimal);
        TextView resultField = (TextView) findViewById(R.id.editTextNumberDecimal2);

        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        Button clear = (Button) findViewById(R.id.clear_text);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enterField.setText("");
                resultField.setText("Result");
            }
        });

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner initialUnit = (Spinner) findViewById(R.id.spinner_time2);
                String unitData1 = initialUnit.getSelectedItem().toString();
                Spinner finalUnit = (Spinner) findViewById(R.id.spinner_time1);
                String unitData2 = finalUnit.getSelectedItem().toString();

                EditText getNum = (EditText) findViewById(R.id.editTextNumberDecimal);
                String stringNum = getNum.getText().toString();
                double convertNum = Double.parseDouble(stringNum);
                double convertedNum = 0;

                if(unitData1.equals("s") && unitData2.equals("ms")){
                    convertedNum = convertNum * 1000 ;
                }else if(unitData1.equals("s") && unitData2.equals("min")){
                    convertedNum = convertNum / 60 ;
                } else if(unitData1.equals("s") && unitData2.equals("hr")){
                    convertedNum = convertNum / 3600 ;
                }else if(unitData1.equals("s") && unitData2.equals("day")){
                    convertedNum = convertNum / 86400;
                }else if(unitData1.equals("ms") && unitData2.equals("s")){
                    convertedNum = convertNum / 1000;
                }else if(unitData1.equals("ms") && unitData2.equals("min")){
                    convertedNum = convertNum / 60000;
                }else if(unitData1.equals("ms") && unitData2.equals("hr")){
                    convertedNum = convertNum / 3600000;
                }else if(unitData1.equals("ms") && unitData2.equals("day")){
                    convertedNum = convertNum / 86400000;
                }else if(unitData1.equals("min") && unitData2.equals("s")){
                    convertedNum = convertNum * 60;
                }else if(unitData1.equals("min") && unitData2.equals("ms")){
                    convertedNum = convertNum * 60000;
                }else if(unitData1.equals("min") && unitData2.equals("hr")){
                    convertedNum = convertNum / 60;
                }else if(unitData1.equals("min") && unitData2.equals("day")){
                    convertedNum = convertNum / 1440;
                }else if(unitData1.equals("hr") && unitData2.equals("s")){
                    convertedNum = convertNum * 3600;
                }else if(unitData1.equals("hr") && unitData2.equals("ms")){
                    convertedNum = convertNum * 3600000;
                }else if(unitData1.equals("hr") && unitData2.equals("min")){
                    convertedNum = convertNum * 60;
                }else if(unitData1.equals("hr") && unitData2.equals("day")){
                    convertedNum = convertNum / 24;
                }else if(unitData1.equals("day") && unitData2.equals("s")){
                    convertedNum = convertNum * 86400;
                }else if(unitData1.equals("day") && unitData2.equals("ms")){
                    convertedNum = convertNum * 86400000;
                }else if(unitData1.equals("day") && unitData2.equals("min")){
                    convertedNum = convertNum * 1440;
                }else if(unitData1.equals("day") && unitData2.equals("day")){
                    convertedNum = convertNum * 24;
                }

                resultField.setText(decimalFormat.format(convertedNum));
                Log.v("myApp", unitData1 + unitData2 + convertNum);
            }
        });
    }
}
