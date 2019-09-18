package com.example.aula1ex2_soma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView  resultadoTextView;
    EditText  num1EditText;
    EditText  num2EditText;
    Button    somarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultadoTextView = findViewById(R.id.ID1_RESULTADOtextView);
        num1EditText      = findViewById(R.id.ID1_NUM1editText);
        num2EditText      = findViewById(R.id.ID1_NUM2editText2);
        somarButton       = findViewById(R.id.ID1_SOMARbutton);
        somarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////////////////////
                String num1s = num1EditText.getText().toString();
                String num2s = num2EditText.getText().toString();
                double num1 = Double.parseDouble(num1s);
                double num2 = Double.parseDouble(num2s);
                double res  = num1 + num2;
                String resS = Double.toString(res);
                resultadoTextView.setText(resS);
                /////////////////
            }
        });




    }
}
