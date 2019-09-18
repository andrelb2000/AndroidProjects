package br.com.amm.aula4ex1reciclagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TotalMain2Activity extends AppCompatActivity {
    private TextView totalItensTextView;
    private TextView totalValorTextView;
    private TextView listaItensTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_main2);
        totalItensTextView  = (TextView) findViewById(R.id.ID2_TOTALITENStextView9);
        totalValorTextView  = (TextView) findViewById(R.id.ID2_TOTALVALORtextView10);
        listaItensTextView  = (TextView) findViewById(R.id.ID2_LISTAtextView8);

        /// Agora vamos coletar os valores enviados pela activity que criou esta aqui:
        Intent it = getIntent();
        Bundle  trouxa = it.getExtras();
        int nrItens = trouxa.getInt("NUMITENS");
        double totalValor = trouxa.getDouble("TOTALVALOR");
        String lista = trouxa.getString("LISTA");

        totalItensTextView.setText(" "+ nrItens);
        totalValorTextView.setText(" "+ totalValor);
        listaItensTextView.setText(lista);
    }
}
