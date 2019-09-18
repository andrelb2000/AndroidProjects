package br.com.amm.aularevav1_veiculo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private ControladorBanco controladorBanco;
    private Intent detalheMotoristaIntent;

    private EditText nomeMotoristaEditText;
    private EditText marcaEditText;
    private EditText multasEditText;
    private EditText precoEditText;

    private Button   insereButton;
    private Button   limpaButton;
    private Button   carregaButton;
    private Button   mediaButton;

    private EditText mediaPrecoEditText;

    private ListView                  listaListView;
    private ArrayList<Motorista>     arrayList;
    private ArrayAdapter<Motorista>  arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controladorBanco = new ControladorBanco(this);
        detalheMotoristaIntent = new Intent(this,MotoristaDetalheActivity.class);
        inicializarComponentes();
        inicializarListeners();
    }
    protected void inicializarComponentes(){
        nomeMotoristaEditText  = (EditText) findViewById(R.id.ID1_MOTORISTAeditText);
        marcaEditText          = (EditText) findViewById(R.id.ID1_MARCAeditText2);
        multasEditText         = (EditText) findViewById(R.id.ID1_MULTASeditText3);
        precoEditText          = (EditText) findViewById(R.id.ID1_PRECOeditText4);

        mediaPrecoEditText     = (EditText) findViewById(R.id.ID1_MEDIAeditText5);

        insereButton           = (Button) findViewById(R.id.ID1_INSEREbutton);
        limpaButton            = (Button) findViewById(R.id.ID1_LIMPAbutton2);
        carregaButton          = (Button) findViewById(R.id.ID1_CARREGAbutton3);
        mediaButton            = (Button) findViewById(R.id.ID1_MEDIAbutton4);

        listaListView   = (ListView) findViewById(R.id.ID1_MOTORISTAListView)   ;
        arrayList       = new ArrayList<Motorista>();
        arrayAdapter    = new ArrayAdapter<Motorista>(this,android.R.layout.simple_list_item_1,
                                                       arrayList) ;
        listaListView.setAdapter(arrayAdapter);
    }
    protected void inicializarListeners(){
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// Obter os dados digitados e trasnformar em um objeto ///
                String motorista = nomeMotoristaEditText.getText().toString();
                String marca     = marcaEditText.getText().toString();
                int    nr        = Integer.parseInt(multasEditText.getText().toString());
                double preco     = Double.parseDouble(precoEditText.getText().toString());
                Motorista m = new Motorista(motorista,marca,nr,preco);
                ///////////////////////////////////////////////////////////////
                //// --- Adicionar na lista ------------------////
                arrayList.add(m);
                arrayAdapter.notifyDataSetChanged();
                //// --- Inserir no banco de dados ---- ///
                controladorBanco.inserirMotorista(m);
            }
        });
        limpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.clear();
                arrayAdapter.notifyDataSetChanged();
            }
        });
        carregaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.clear();
                controladorBanco.carregarLista(arrayList);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        mediaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double media = 0; int nr_Carros = 0;
                Iterator<Motorista> it = arrayList.iterator();
                while (it.hasNext()){
                    Motorista m = it.next();
                    media += m.getPrecoCarro();
                    nr_Carros ++;
                }
                media /= nr_Carros;
                mediaPrecoEditText.setText(""+media);
            }
        });
        listaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Motorista m = (Motorista) adapterView.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putString("MOTORISTA",m.getNomeMotorista());
                bundle.putString("MARCA",m.getMarcaCarro());
                bundle.putInt("MULTAS",m.getNrMultas());
                bundle.putDouble("PRECO",m.getPrecoCarro());
                detalheMotoristaIntent.putExtras(bundle);
                startActivity(detalheMotoristaIntent);

            }
        });
    }
}
