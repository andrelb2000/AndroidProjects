package br.com.amm.aula4ex1intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MostraDadosActivity extends AppCompatActivity {
    private TextView nomeTextView;
    private TextView cepTextView;
    private TextView numeroTextView;
    private TextView aptTextView;
    private TextView telTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_dados);
        nomeTextView   = (TextView) findViewById(R.id.IDNomeTextView);
        cepTextView    = (TextView) findViewById(R.id.IDCEPtextView);
        numeroTextView = (TextView) findViewById(R.id.IDNUMtextView);
        aptTextView    = (TextView) findViewById(R.id.IDAPTtextView);
        telTextView    = (TextView) findViewById(R.id.IDTeltextView);
        Intent intentOrigem = getIntent();

        /// Na origem:
        //  dadosEnviados.putString("NOME",nomeEditText.getText().toString());
        // No destino
        String nomeOrigem = intentOrigem.getExtras().getString("NOME");
        nomeTextView.setText(nomeOrigem);

    }
}
