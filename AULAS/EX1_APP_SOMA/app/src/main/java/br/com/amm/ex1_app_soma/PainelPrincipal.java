package br.com.amm.ex1_app_soma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PainelPrincipal extends AppCompatActivity {

    EditText num1 = null;
    EditText num2 = null;
    TextView result = null;
    Button somar = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_principal);

        num1 = (EditText) findViewById(R.id.editTextNum1);
        num2 = (EditText) findViewById(R.id.editTextNum2);
        result = (TextView) findViewById(R.id.textViewResult);

        somar = (Button) findViewById(R.id.buttonSoma);
        somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                double soma = n1 + n2;
                result.setText(Double.toString(soma));
            }
        });




    }
}
