package br.com.amm.aula3ex1_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText armaEditText;
    private EditText qdeDisparosEditText;
    private EditText precoArmaEditText;
    private EditText precoMunicaoEditText;
    private EditText qdeArmasEditText;
    private TextView totalTextView;
    private Button   calculaTotalButton;

    private Intent   totalIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        inicializaListeners();
    }


    protected void inicializaComponentes(){
        armaEditText         = (EditText) findViewById(R.id.ID1_ARMAeditText);
        qdeDisparosEditText  = (EditText) findViewById(R.id.ID1_QDEDISPeditText2);
        precoArmaEditText    = (EditText) findViewById(R.id.ID1_PRECO_ARMAeditText3);
        precoMunicaoEditText = (EditText) findViewById(R.id.ID1_PRECO_MUNeditText4);
        qdeArmasEditText     = (EditText) findViewById(R.id.ID1_QDE_ARMASeditText5);
        totalTextView        = (TextView) findViewById(R.id.ID1_TOTALtextView6)  ;
        calculaTotalButton   = (Button)   findViewById(R.id.ID1_CALCULARbutton);

        totalIntent          = new Intent(this,TotalArmaActivity.class);

    }

    protected void inicializaListeners(){
        calculaTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int    qdeDisp    = Integer.parseInt(qdeDisparosEditText.getText().toString());
                double precoArma  = Double.parseDouble(precoArmaEditText.getText().toString());
                double precoMun   = Double.parseDouble(precoMunicaoEditText.getText().toString());
                int    qdeArmas   = Integer.parseInt(qdeArmasEditText.getText().toString());

                double total = ((qdeDisp * precoMun) + precoArma)*qdeArmas;

                totalTextView.setText("Preço total da "+
                                       armaEditText.getText().toString()+
                                       " R$ "+total);

                Bundle trouxa = new Bundle();
                trouxa.putDouble("TOTAL",total);

                totalIntent.putExtras(trouxa);

                startActivity(totalIntent);


            }
        });
    }

}
