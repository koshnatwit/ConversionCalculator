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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Temperature");

        Spinner spinnerTemp1 = findViewById(R.id.spinner_temp1);
        Spinner spinnerTemp2 = findViewById(R.id.spinner_temp2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTemp1.setAdapter(adapter);
        spinnerTemp2.setAdapter(adapter);

        EditText enterField = (EditText) findViewById(R.id.editTextNumberDecimal);
        TextView resultField = (TextView) findViewById(R.id.editTextNumberDecimal2);

        Button clear = (Button) findViewById(R.id.clear_text);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enterField.setText("");
                resultField.setText("Result");
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
                String firstUnit = spinnerTemp2.getSelectedItem().toString();
                String secondUnit = spinnerTemp1.getSelectedItem().toString();
                //double firstNum = Double.parseDouble(firstUnit);
                //double secondNum = Double.parseDouble(secondUnit);

                if (firstUnit.equals("F")) {
                    if (secondUnit.equals("C")) {
                        resultField.setText(Double.toString((value-32) * (5/9)));
                    }
                    else if (secondUnit.equals("K")) {
                        resultField.setText(Double.toString((value-32) * (5/9) + 273.15));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
                else if (firstUnit.equals("C")) {
                    if (secondUnit.equals("F")) {
                        resultField.setText(Double.toString((value*(9/5)) +32 ));
                    }
                    else if (secondUnit.equals("K")) {
                        resultField.setText(Double.toString(value + 273 ));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
                else {
                    if (secondUnit.equals("F")) {
                        resultField.setText(Double.toString((value-273.15) * (9/5) + 32 ));
                    }
                    else if (secondUnit.equals("C")) {
                        resultField.setText(Double.toString(value - 273.15 ));
                    }
                    else {
                        resultField.setText(Double.toString(value));
                    }
                }
            }
        });
    }
}
