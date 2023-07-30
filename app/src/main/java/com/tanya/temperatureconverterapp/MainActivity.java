package com.tanya.temperatureconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button button,again;
    TextView answer;
    RadioButton CtoF,FtoC;
    EditText temp;
    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        answer=(TextView) findViewById(R.id.answer);
        temp=(EditText) findViewById(R.id.temp);
        CtoF=(RadioButton) findViewById(R.id.CtoF);
        FtoC=(RadioButton) findViewById(R.id.FtoC);
        again=(Button) findViewById(R.id.again);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp.getText().toString().isEmpty()){
                    answer.setText("Please give temperature");
                }
                else{
                    x=Double.parseDouble(String.valueOf(temp.getText()));
                   if(CtoF.isChecked()){
                       x=(x*9)/5+32;
                       x=Double.parseDouble(new DecimalFormat("##.###").format(x));
                       answer.setText(String.valueOf(x) + " Degree F");
                   }
                   else if(FtoC.isChecked()){
                       x=(x-32)*5/9;
                       x=Double.parseDouble(new DecimalFormat("##.###").format(x));
                       answer.setText(String.valueOf(x) + " Degree C");

                   }
                   else{
                       answer.setText("Please select option");
                   }
                }
            }
        });
        again.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("0.0");
                temp.setText("");
                CtoF.setChecked(false);
                FtoC.setChecked(false);

            }
        }));
    }
}
