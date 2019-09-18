package com.example.aula05ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText estadoEditText;
    private EditText populacaoEditText;
    private Button   insereButton;
    private Button   carregaButton;

    private ListView                   listaEstadosListView;
    private ArrayList<EstadoModelo>    lista;
    private ArrayAdapter<EstadoModelo> listaArrayAdapter;

    private GerenciadorBanco      gerenciadorBanco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gerenciadorBanco = new GerenciadorBanco(this);
        inicializaComponentes();
        inicializaListeners();
    }

    public void inicializaComponentes(){
        estadoEditText     = findViewById(R.id.ID_ESTADOeditText);
        populacaoEditText  = findViewById(R.id.ID1_POPeditText2);
        insereButton       = findViewById(R.id.ID1_INSEREbutton);
        carregaButton      = findViewById(R.id.ID1_CARREGAbutton2);

        listaEstadosListView = findViewById(R.id.ID1_ESTADOListView);
        lista                = new ArrayList<EstadoModelo>();
        listaArrayAdapter    = new ArrayAdapter<EstadoModelo>(this,
                android.R.layout.simple_expandable_list_item_1,
                lista);
        listaEstadosListView.setAdapter(listaArrayAdapter);
    }
    public void inicializaListeners(){
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EstadoModelo em = obterEstadoDigitado();
                lista.add(em);
                listaArrayAdapter.notifyDataSetChanged();
                gerenciadorBanco.inserir(em);
            }
        });
        carregaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.clear();
                listaArrayAdapter.clear();
                gerenciadorBanco.carregar(lista);
                listaArrayAdapter.notifyDataSetChanged();
            }
        });
    }
    protected EstadoModelo obterEstadoDigitado(){
        String nome = estadoEditText.getText().toString();
        int    pop  = Integer.parseInt(populacaoEditText.getText().toString());
        EstadoModelo em = new EstadoModelo(nome,pop);
        return em;
    }



}
