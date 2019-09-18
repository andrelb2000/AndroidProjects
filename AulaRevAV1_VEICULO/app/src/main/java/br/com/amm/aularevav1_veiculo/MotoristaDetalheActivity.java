package br.com.amm.aularevav1_veiculo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MotoristaDetalheActivity extends AppCompatActivity {
    private Intent voltarIntent;

    private EditText nomeMotoristaEditText;
    private EditText marcaEditText;
    private EditText multasEditText;
    private EditText precoEditText;

    private Button  voltaButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorista_detalhe);
        voltarIntent = new Intent(this,MainActivity.class);
        inicializarComponentes();
        inicializarListeners();

    }
    private void inicializarComponentes(){
        nomeMotoristaEditText  = (EditText) findViewById(R.id.ID2_MOTORISTAeditText6);
        marcaEditText          = (EditText) findViewById(R.id.ID2_MARCAeditText7);
        multasEditText         = (EditText) findViewById(R.id.ID2_MULTASeditText8);
        precoEditText          = (EditText) findViewById(R.id.ID2_PRECOeditText9);
        voltaButton            = (Button)   findViewById(R.id.ID2_VOLTARbutton5);
        Bundle b = getIntent().getExtras();

        nomeMotoristaEditText.setText(b.getString("MOTORISTA"));
        marcaEditText.setText(b.getString("MARCA"));
        multasEditText.setText(Integer.toString(b.getInt("MULTAS")));
        precoEditText.setText(Double.toString(b.getDouble("PRECO")));
    }
    private void inicializarListeners(){
        voltaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(voltarIntent);
            }
        });
    }
}
