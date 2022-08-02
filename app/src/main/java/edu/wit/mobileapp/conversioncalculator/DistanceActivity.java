package edu.wit.mobileapp.conversioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class DistanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinnerDistance1 = findViewById(R.id.spinner_dist1);
        Spinner spinnerDistance2 = findViewById(R.id.spinner_dist2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.distance, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDistance1.setAdapter(adapter);
        spinnerDistance2.setAdapter(adapter);

        EditText enterField = (EditText) findViewById(R.id.editTextNumberDecimal);
        TextView resultField = (TextView) findViewById(R.id.editTextNumberDecimal2);

        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        Button clear = (Button) findViewById(R.id.clear_text);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Clear is clicked");
                enterField.setText("");
                resultField.setText("Result");
            }
        });

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner initialUnit = (Spinner) findViewById(R.id.spinner_dist1);
                String unitData1 = initialUnit.getSelectedItem().toString();
                Spinner finalUnit = (Spinner) findViewById(R.id.spinner_dist2);
                String unitData2 = finalUnit.getSelectedItem().toString();

                EditText getNum = (EditText) findViewById(R.id.editTextNumberDecimal);
                String stringNum = getNum.getText().toString();
                double convertNum = Double.parseDouble(stringNum);
                double convertedNum = 0;

                if(unitData1.equals("m") && unitData2.equals("cm")){
                    convertedNum = convertNum * 100;
                }else if(unitData1.equals("m") && unitData2.equals("mm")){
                    convertedNum = convertNum * 1000;
                }else if(unitData1.equals("m") && unitData2.equals("km")){
                    convertedNum = convertNum / 1000 ;
                }else if(unitData1.equals("m") && unitData2.equals("ft")){
                    convertedNum = convertNum * 3.28084 ;
                }else if(unitData1.equals("m") && unitData2.equals("in")){
                    convertedNum = convertNum * 39.3701 ;
                }else if(unitData1.equals("m") && unitData2.equals("yd")){
                    convertedNum = convertNum * 1.09361 ;
                }else if(unitData1.equals("m") && unitData2.equals("mile")){
                    convertedNum = convertNum * 0.00062137 ;
                }else if(unitData1.equals("cm") && unitData2.equals("m")){
                    convertedNum = convertNum / 100 ;
                }else if(unitData1.equals("cm") && unitData2.equals("mm")){
                    convertedNum = convertNum * 10 ;
                }else if(unitData1.equals("cm") && unitData2.equals("km")){
                    convertedNum = convertNum / 100000 ;
                }else if(unitData1.equals("cm") && unitData2.equals("ft")){
                    convertedNum = convertNum * 0.0328084 ;
                }else if(unitData1.equals("cm") && unitData2.equals("in")){
                    convertedNum = convertNum / 2.54 ;
                }else if(unitData1.equals("cm") && unitData2.equals("yd")){
                    convertedNum = convertNum * 0.0328084 * 3;
                }else if(unitData1.equals("cm") && unitData2.equals("mile")){
                    convertedNum = convertNum / 160934 ;
                }else if(unitData1.equals("mm") && unitData2.equals("m")){
                    convertedNum = convertNum / 1000 ;
                }else if(unitData1.equals("mm") && unitData2.equals("cm")){
                    convertedNum = convertNum  / 10;
                }else if(unitData1.equals("mm") && unitData2.equals("km")){
                    convertedNum = convertNum / 1000000 ;
                }else if(unitData1.equals("mm") && unitData2.equals("ft")){
                    convertedNum = convertNum  / 304.8 ;
                }else if(unitData1.equals("mm") && unitData2.equals("in")){
                    convertedNum = convertNum  / 25.4;
                }else if(unitData1.equals("mm") && unitData2.equals("yd")){
                    convertedNum = convertNum  / 304.8 * 3;
                }else if(unitData1.equals("mm") && unitData2.equals("mile")){
                    convertedNum = convertNum / 1609340 ;
                }else if(unitData1.equals("km") && unitData2.equals("m")){
                    convertedNum = convertNum * 1000;
                }else if(unitData1.equals("km") && unitData2.equals("cm")){
                    convertedNum = convertNum * 100000 ;
                }else if(unitData1.equals("km") && unitData2.equals("mm")){
                    convertedNum = convertNum * 1000000 ;
                }else if(unitData1.equals("km") && unitData2.equals("ft")){
                    convertedNum = convertNum * 3280.84 ;
                }else if(unitData1.equals("km") && unitData2.equals("in")){
                    convertedNum = convertNum * 39370.1 ;
                }else if(unitData1.equals("km") && unitData2.equals("yd")){
                    convertedNum = convertNum * 1093.61389;
                }else if(unitData1.equals("km") && unitData2.equals("mile")){
                    convertedNum = convertNum * 0.621371 ;
                }else if(unitData1.equals("ft") && unitData2.equals("m")){
                    convertedNum = convertNum / 3.28084 ;
                }else if(unitData1.equals("ft") && unitData2.equals("cm")){
                    convertedNum = convertNum * 30.84 ;
                }else if(unitData1.equals("ft") && unitData2.equals("mm")){
                    convertedNum = convertNum * 304.8 ;
                }else if(unitData1.equals("ft") && unitData2.equals("km")){
                    convertedNum = convertNum / 3280.84 ;
                }else if(unitData1.equals("ft") && unitData2.equals("in")){
                    convertedNum = convertNum * 12 ;
                }else if(unitData1.equals("ft") && unitData2.equals("yd")){
                    convertedNum = convertNum / 3 ;
                }else if(unitData1.equals("ft") && unitData2.equals("mile")){
                    convertedNum = convertNum / 5280 ;
                }else if(unitData1.equals("in") && unitData2.equals("m")){
                    convertedNum = convertNum * .0254 ;
                }else if(unitData1.equals("in") && unitData2.equals("cm")){
                    convertedNum = convertNum * 2.54 ;
                }else if(unitData1.equals("in") && unitData2.equals("mm")){
                    convertedNum = convertNum * 25.4 ;
                }else if(unitData1.equals("in") && unitData2.equals("km")){
                    convertedNum = convertNum / 39370.1 ;
                }else if(unitData1.equals("in") && unitData2.equals("ft")){
                    convertedNum = convertNum / 12 ;
                }else if(unitData1.equals("in") && unitData2.equals("yd")){
                    convertedNum = convertNum / 36 ;
                }else if(unitData1.equals("in") && unitData2.equals("mile")){
                    convertedNum = convertNum / 63360;
                }else if(unitData1.equals("yd") && unitData2.equals("m")){
                    convertedNum = convertNum * 0.9144 ;
                }else if(unitData1.equals("yd") && unitData2.equals("cm")){
                    convertedNum = convertNum * 91.44 ;
                }else if(unitData1.equals("yd") && unitData2.equals("mm")){
                    convertedNum = convertNum * 914.4 ;
                }else if(unitData1.equals("yd") && unitData2.equals("km")){
                    convertedNum = convertNum * 0.0009144;
                }else if(unitData1.equals("yd") && unitData2.equals("in")){
                    convertedNum = convertNum * 36 ;
                }else if(unitData1.equals("yd") && unitData2.equals("ft")){
                    convertedNum = convertNum * 3;
                }else if(unitData1.equals("yd") && unitData2.equals("mile")){
                    convertedNum = convertNum / 1760 ;
                }else if(unitData1.equals("mile") && unitData2.equals("m")){
                    convertedNum = convertNum / 0.00062137 ;
                }else if(unitData1.equals("mile") && unitData2.equals("cm")){
                    convertedNum = convertNum * 160934 ;
                }else if(unitData1.equals("mile") && unitData2.equals("mm")){
                    convertedNum = convertNum * 1609340 ;
                }else if(unitData1.equals("mile") && unitData2.equals("km")){
                    convertedNum = convertNum * 1.60934 ;
                }else if(unitData1.equals("mile") && unitData2.equals("ft")){
                    convertedNum = convertNum * 5280 ;
                }else if(unitData1.equals("mile") && unitData2.equals("in")){
                    convertedNum = convertNum * 63360 ;
                }else if(unitData1.equals("mile") && unitData2.equals("yd")){
                    convertedNum = convertNum * 1760 ;
                }

                resultField.setText(decimalFormat.format(convertedNum));
                Log.v("myApp", unitData1 + unitData2 + convertNum);

            }
        });
    }
}
