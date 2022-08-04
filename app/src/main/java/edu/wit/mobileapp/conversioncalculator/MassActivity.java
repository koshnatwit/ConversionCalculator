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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("my app", "start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Mass");


        Spinner spinnerMass1 = findViewById(R.id.spinner_mass1);
        Spinner spinnerMass2 = findViewById(R.id.spinner_mass2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mass, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMass1.setAdapter(adapter);
        spinnerMass2.setAdapter(adapter);

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
        Log.v("my app", "before");
        ImageButton switchUnit = (ImageButton) findViewById(R.id.imageButtonSwitch);
        switchUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("my app", "in on click");
                int spinner1Index = spinnerMass1.getSelectedItemPosition();
                spinnerMass1.setSelection(spinnerMass2.getSelectedItemPosition());
                spinnerMass2.setSelection(spinner1Index);
            }
        });


        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner initialUnit = (Spinner) findViewById(R.id.spinner_mass2);
                String unitData1 = initialUnit.getSelectedItem().toString();
                Spinner finalUnit = (Spinner) findViewById(R.id.spinner_mass1);
                String unitData2 = finalUnit.getSelectedItem().toString();

                EditText getNum = (EditText) findViewById(R.id.editTextNumberDecimal);
                String stringNum = getNum.getText().toString();
                double convertNum = Double.parseDouble(stringNum);
                double convertedNum = 0;
                if (unitData1.equals(unitData2)){
                    convertedNum = convertNum;
                } else if(unitData1.equals("kg")){
                    switch (unitData2) {
                        case "g":
                            convertedNum = convertNum * 1000;
                            break;
                        case "mg":
                            convertedNum = convertNum * 1000000;
                            break;
                        case "lb":
                            convertedNum = convertNum * 2.20462;
                            break;
                        case "slug":
                            convertedNum = convertNum * 0.0685218;
                            break;
                        case "tonne":
                            convertedNum = convertNum * 0.001;
                            break;
                        case "ton":
                            convertedNum = convertNum * 0.00110231;
                            break;
                        case "oz":
                            convertedNum = convertNum * 35.274;
                            break;
                    }
                }else if(unitData1.equals("g")){
                    switch (unitData2) {
                        case "kg":
                            convertedNum = convertNum / 1000;
                            break;
                        case "mg":
                            convertedNum = convertNum * 1000;
                            break;
                        case "lb":
                            convertedNum = convertNum * 0.00220462;
                            break;
                        case "slug":
                            convertedNum = convertNum * 0.00006854;
                            break;
                        case "tonne":
                            convertedNum = convertNum * 0.000001;
                            break;
                        case "ton":
                            convertedNum = convertNum * 0.00000110231;
                            break;
                        case "oz":
                            convertedNum = convertNum * 0.035274;
                            break;
                    }
                }else if(unitData1.equals("mg")){
                    switch (unitData2) {
                        case "kg":
                            convertedNum = convertNum / 1000000;
                            break;
                        case "g":
                            convertedNum = convertNum / 1000;
                            break;
                        case "lb":
                            convertedNum = convertNum * 0.00000220462;
                            break;
                        case "slug":
                            convertedNum = convertNum * 0.0000000685218;
                            break;
                        case "tonne":
                            convertedNum = convertNum * 0.000000001;
                            break;
                        case "ton":
                            convertedNum = convertNum * 0.00000000110231;
                            break;
                        case "oz":
                            convertedNum = convertNum * 0.000035274;
                            break;
                    }
                }else if(unitData1.equals("lb")){
                    switch (unitData2) {
                        case "kg":
                            convertedNum = convertNum / 2.20462;
                            break;
                        case "g":
                            convertedNum = convertNum / 0.00220462;
                            break;
                        case "mg":
                            convertedNum = convertNum / 0.00000220462;
                            break;
                        case "slug":
                            convertedNum = convertNum / 32.174;
                            break;
                        case "tonne":
                            convertedNum = convertNum * 0.000453592;
                            break;
                        case "ton":
                            convertedNum = convertNum * 0.0005;
                            break;
                        case "oz":
                            convertedNum = convertNum * 16;
                            break;
                    }
                }else if(unitData1.equals("slug")){
                    switch (unitData2) {
                        case "kg":
                            convertedNum = convertNum / 0.0685218;
                            break;
                        case "g":
                            convertedNum = convertNum / 0.0000685400959561343;
                            break;
                        case "mg":
                            convertedNum = convertNum / 0.0000000685218;
                            break;
                        case "lb":
                            convertedNum = convertNum * 32.174;
                            break;
                        case "tonne":
                            convertedNum = convertNum * 0.0145939;
                            break;
                        case "ton":
                            convertedNum = convertNum * 0.016087;
                            break;
                        case "oz":
                            convertedNum = convertNum * 514.785;
                            break;
                    }
                }else if(unitData1.equals("tonne")){
                    switch (unitData2) {
                        case "kg":
                            convertedNum = convertNum / 0.001;
                            break;
                        case "g":
                            convertedNum = convertNum / 0.000001;
                            break;
                        case "mg":
                            convertedNum = convertNum / 0.000000001;
                            break;
                        case "lb":
                            convertedNum = convertNum / 0.000453592;
                            break;
                        case "slug":
                            convertedNum = convertNum / 0.0145939;
                            break;
                        case "ton":
                            convertedNum = convertNum * 1.10231;
                            break;
                        case "oz":
                            convertedNum = convertNum * 35274;
                            break;
                    }
                }else if(unitData1.equals("ton")){
                    switch (unitData2) {
                        case "kg":
                            convertedNum = convertNum / 0.00110231;
                            break;
                        case "g":
                            convertedNum = convertNum / 0.00000110231;
                            break;
                        case "mg":
                            convertedNum = convertNum / 0.00000000110231;
                            break;
                        case "lb":
                            convertedNum = convertNum / 0.0005;
                            break;
                        case "slug":
                            convertedNum = convertNum / 0.016087;
                            break;
                        case "tonne":
                            convertedNum = convertNum / 1.10231;
                            break;
                        case "oz":
                            convertedNum = convertNum * 32000;
                            break;
                    }
                }else if(unitData1.equals("oz")){
                    switch (unitData2) {
                        case "kg":
                            convertedNum = convertNum / 35.274;
                            break;
                        case "g":
                            convertedNum = convertNum / 0.035274;
                            break;
                        case "mg":
                            convertedNum = convertNum / 0.000035274;
                            break;
                        case "lb":
                            convertedNum = convertNum / 16;
                            break;
                        case "slug":
                            convertedNum = convertNum / 514.785;
                            break;
                        case "tonne":
                            convertedNum = convertNum / 35274;
                            break;
                        case "ton":
                            convertedNum = convertNum / 32000;
                            break;
                    }
                }

                resultField.setText(decimalFormat.format(convertedNum));
                Log.v("myApp", unitData1 + unitData2 + convertNum);

            }
        });



    }
}
