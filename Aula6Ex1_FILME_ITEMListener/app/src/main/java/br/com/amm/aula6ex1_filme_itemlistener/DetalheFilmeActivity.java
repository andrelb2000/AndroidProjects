package br.com.amm.aula6ex1_filme_itemlistener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DetalheFilmeActivity extends AppCompatActivity {
    private EditText nomeFilmeEditText;
    private EditText atorEditText;
    private EditText dataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        nomeFilmeEditText = (EditText) findViewById(R.id.ID2_FILMEeditText);
        atorEditText      = (EditText) findViewById(R.id.ID2_ATOReditText2);
        dataEditText       = (EditText) findViewById(R.id.ID2_DATAeditText3);

        Intent intentPai =        getIntent();

        Bundle trouxa = intentPai.getExtras();

        nomeFilmeEditText.setText(trouxa.getString("FILME"));
        atorEditText.setText(trouxa.getString("ATOR"));
        dataEditText.setText(trouxa.getString("DATA"));
    }
}
