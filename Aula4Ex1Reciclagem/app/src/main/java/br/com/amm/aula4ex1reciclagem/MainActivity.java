package br.com.amm.aula4ex1reciclagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText tipoItemEditText;
    private EditText pesoItemEditText;
    private EditText precoKiloEditText;
    private EditText qdeItemEditText;
    private TextView totalItensTextView;
    private Button   insereButton;
    private Button   mostraButton;
    // Agora para acumular os valores totais:
    private int totalItens = 0;
    private double totalValor = 0;
    private String listaItens = "";
    // E vamos precisar de uma Intent pra poder abrir a outra janela
    private Intent mostraTotalIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        inicializaListeners();
    }
    // Só pra organizar:
    protected void inicializaComponentes(){
        tipoItemEditText    = (EditText) findViewById(R.id.ID1_TIPOeditText);
        pesoItemEditText    = (EditText) findViewById(R.id.ID1_PESOeditText2);
        precoKiloEditText   = (EditText) findViewById(R.id.ID1_PRECOeditText3);
        qdeItemEditText     = (EditText) findViewById(R.id.ID1_QDEeditText4);
        totalItensTextView  = (TextView) findViewById(R.id.ID1_TOTITENStextView5);
        insereButton        = (Button)   findViewById(R.id.ID1_INSERIRbutton);
        mostraButton        = (Button)   findViewById(R.id.ID1_MOSTRARbutton2);
        /// Inicializar a INTENT para poder abrir a segunda tela:
        mostraTotalIntent   = new Intent(this,TotalMain2Activity.class);
        ////////////////////////////////////////////////////////



    }
    protected void inicializaListeners(){
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pesoItem  = Double.parseDouble(pesoItemEditText.getText().toString());
                double precoKilo = Double.parseDouble(precoKiloEditText.getText().toString());
                int    qde       = Integer.parseInt(qdeItemEditText.getText().toString());
                String tipo      = tipoItemEditText.getText().toString();
                // Acumula total de itens
                totalItens  += qde;
                //Acumula total ganho
                totalValor  += (qde*pesoItem)*precoKilo;
                // Acumula lista de itens:
                listaItens += "- "+tipo+"\n";

                // Mostra total ganho
                totalItensTextView.setText("Nr. Itens: "+totalItens);
            }
        });
        /////////////////////////////////////////
        mostraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// 1 - Criar trouxa para enviar para a segunda tela
                Bundle trouxa = new Bundle();
                trouxa.putInt("NUMITENS",totalItens);
                trouxa.putDouble("TOTALVALOR",totalValor);
                trouxa.putString("LISTA",listaItens);
                /// 2 - Colocar trouxa na "Intent"
                mostraTotalIntent.putExtras(trouxa);
                /// 3 - DISPARAR !!!
                startActivity(mostraTotalIntent);
                // Nao se esqueça de coletar do outro lado!!!!
            }
        });
        //////////////////////////////////////////

    }
}
