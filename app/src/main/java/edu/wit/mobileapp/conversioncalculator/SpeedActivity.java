package edu.wit.mobileapp.conversioncalculator;

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

public class SpeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinnerSpeed1 = findViewById(R.id.spinner_speed1);
        Spinner spinnerSpeed2 = findViewById(R.id.spinner_speed2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.speed, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSpeed1.setAdapter(adapter);
        spinnerSpeed2.setAdapter(adapter);

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

        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = Double.parseDouble(enterField.getText().toString());
                String firstUnit = spinnerSpeed2.getSelectedItem().toString();
                String secondUnit = spinnerSpeed1.getSelectedItem().toString();

                if (firstUnit.equals("m/s")) {
                    if (secondUnit.equals("km/s")) {
                        resultField.setText(decimalFormat.format(value / 1000));
                    }
                    else if (secondUnit.equals("kmh")) {
                        resultField.setText(decimalFormat.format(value * 3.6));
                    }
                    else if (secondUnit.equals("mph")) {
                        resultField.setText(decimalFormat.format(value * 2.2369));
                    }
                    else if (secondUnit.equals("in/s")) {
                        resultField.setText(decimalFormat.format(value / 0.0254));
                    }
                    else if (secondUnit.equals("ft/s")) {
                        resultField.setText(decimalFormat.format(value * 3.28084));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
                else if (firstUnit.equals("km/s")) {
                    if (secondUnit.equals("m/s")) {
                        resultField.setText(decimalFormat.format(value * 1000));
                    }
                    else if (secondUnit.equals("kmh")) {
                        resultField.setText(decimalFormat.format(value * 3600));
                    }
                    else if (secondUnit.equals("mph")) {
                        resultField.setText(decimalFormat.format(value * 2236.94));
                    }
                    else if (secondUnit.equals("in/s")) {
                        resultField.setText(decimalFormat.format(value * 39370.1));
                    }
                    else if (secondUnit.equals("ft/s")) {
                        resultField.setText(decimalFormat.format(value * 3280.84));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
                else if (firstUnit.equals("kmh")) {
                    if (secondUnit.equals("m/s")) {
                        resultField.setText(decimalFormat.format(value / 3.6));
                    }
                    else if (secondUnit.equals("km/s")) {
                        resultField.setText(decimalFormat.format(value / 3600));
                    }
                    else if (secondUnit.equals("mph")) {
                        resultField.setText(decimalFormat.format(value / 1.609344));
                    }
                    else if (secondUnit.equals("in/s")) {
                        resultField.setText(decimalFormat.format(value * 10.9361));
                    }
                    else if (secondUnit.equals("ft/s")) {
                        resultField.setText(decimalFormat.format(value * 0.911344));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
                else if (firstUnit.equals("mph")) {
                    if (secondUnit.equals("m/s")) {
                        resultField.setText(decimalFormat.format(value / 2.237));
                    }
                    else if (secondUnit.equals("km/s")) {
                        resultField.setText(decimalFormat.format(value * 0.000447));
                    }
                    else if (secondUnit.equals("kmh")) {
                        resultField.setText(decimalFormat.format(value * 1.609344));
                    }
                    else if (secondUnit.equals("in/s")) {
                        resultField.setText(decimalFormat.format(value * 17.6));
                    }
                    else if (secondUnit.equals("ft/s")) {
                        resultField.setText(decimalFormat.format(value * 1.466667));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
                else if (firstUnit.equals("in/s")) {
                    if (secondUnit.equals("m/s")) {
                        resultField.setText(decimalFormat.format(value / 39.37));
                    }
                    else if (secondUnit.equals("km/s")) {
                        resultField.setText(decimalFormat.format(value * 2236.94));
                    }
                    else if (secondUnit.equals("kmh")) {
                        resultField.setText(decimalFormat.format(value / 10.9361));
                    }
                    else if (secondUnit.equals("mph")) {
                        resultField.setText(decimalFormat.format(value / 17.6));
                    }
                    else if (secondUnit.equals("ft/s")) {
                        resultField.setText(decimalFormat.format(value / 12));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
                else if (firstUnit.equals("ft/s")) {
                    if (secondUnit.equals("m/s")) {
                        resultField.setText(decimalFormat.format(value * 0.3048));
                    }
                    else if (secondUnit.equals("km/s")) {
                        resultField.setText(decimalFormat.format(value * 0.000305));
                    }
                    else if (secondUnit.equals("kmh")) {
                        resultField.setText(decimalFormat.format(value * 1.09728));
                    }
                    else if (secondUnit.equals("mph")) {
                        resultField.setText(decimalFormat.format(value * 0.681818));
                    }
                    else if (secondUnit.equals("in/s")) {
                        resultField.setText(decimalFormat.format(value * 12));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
            }
        });
    }
}
