package edu.wit.mobileapp.conversioncalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class AngleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Angle");

        Spinner spinnerAngle1 = findViewById(R.id.spinner_angle1);
        Spinner spinnerAngle2 = findViewById(R.id.spinner_angle2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.angle, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAngle1.setAdapter(adapter);
        spinnerAngle2.setAdapter(adapter);

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

        ImageButton switchUnit = (ImageButton) findViewById(R.id.imageButtonSwitch) ;
        switchUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spinner1Index = spinnerAngle1.getSelectedItemPosition();
                spinnerAngle1.setSelection(spinnerAngle2.getSelectedItemPosition());
                spinnerAngle2.setSelection(spinner1Index);
            }
        });

        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(enterField.getText().toString())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No Value Entered", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                double value = Double.parseDouble(enterField.getText().toString());
                String firstUnit = spinnerAngle2.getSelectedItem().toString();
                String secondUnit = spinnerAngle1.getSelectedItem().toString();

                if (firstUnit.equals("rad")) {
                    if (secondUnit.equals("deg")) {
                        Log.v("myApp", "1 " + value + " " + firstUnit + " " + secondUnit);
                        resultField.setText(decimalFormat.format((value * 180.0) / Math.PI));
                    } else {
                        Log.v("myApp", "2 " + value + " " + firstUnit + " " + secondUnit);
                        resultField.setText(Double.toString(value));
                    }
                }
                else {
                    if (secondUnit.equals("rad")) {
                        Log.v("myApp", "3 " + value + " " + firstUnit + " " + secondUnit);
                        resultField.setText(decimalFormat.format((value * Math.PI) / 180.0));
                    } else {
                        Log.v("myApp", "4 " + value + " " + firstUnit + " " + secondUnit);
                        resultField.setText(Double.toString(value));
                    }
                }
            }
        });
    }
}
