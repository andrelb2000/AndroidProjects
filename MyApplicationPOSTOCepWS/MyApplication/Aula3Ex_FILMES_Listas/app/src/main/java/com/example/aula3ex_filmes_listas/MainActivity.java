package com.example.aula3ex_filmes_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText filmeEditText;
    private EditText duracaoEditText;
    private EditText categoriaEditText;
    private TextView totalTextView;
    private Button   adicionarButton;

    private ListView                       listaListView;
    private ArrayList<ProgramaModelo>      lista;
    private ArrayAdapter<ProgramaModelo>   listaArrayAdapter;

    private double totalDuracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmeEditText    = findViewById(R.id.ID1_FILMEeditText);
        duracaoEditText   = findViewById(R.id.ID1_DURACAOeditText2);
        categoriaEditText = findViewById(R.id.ID1_CATEGORIAeditText3);
        totalTextView     = findViewById(R.id.ID1_TOTALtextView5);
        adicionarButton   = findViewById(R.id.ID1_ADDICIONARbutton);

        /////////////////////////////////////////////
        listaListView        = findViewById(R.id.ID1_LISTAListView);
        lista                = new ArrayList<ProgramaModelo>();
        listaArrayAdapter    = new ArrayAdapter<ProgramaModelo>(this,
                            android.R.layout.simple_expandable_list_item_1,
                             lista);
        listaListView.setAdapter(listaArrayAdapter);
        ///////////////////////////
        adicionarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filme = filmeEditText.getText().toString();
                double duracao = Double.parseDouble( duracaoEditText.getText().toString() );
                String categoria = categoriaEditText.getText().toString();
                ProgramaModelo pm = new ProgramaModelo(filme,duracao,categoria);
                totalDuracao += pm.getDuracaoPrograma();
                totalTextView.setText(""+totalDuracao);

                lista.add(pm);
                listaArrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
