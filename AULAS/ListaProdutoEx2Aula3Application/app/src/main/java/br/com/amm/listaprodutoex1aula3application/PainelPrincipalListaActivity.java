package br.com.amm.listaprodutoex1aula3application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PainelPrincipalListaActivity extends AppCompatActivity {

    private EditText insereNomeEditView = null;
    private Button   insereNomeButton = null;

    private ListView             listaItensListView = null;
    private ArrayList<String>    listaItens = null;
    private ArrayAdapter<String> listaItensAdapter = null;

    private TextView selected   = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_principal_lista);
        inicializaComponentes();
        inicializaListeners();
    }

    public void insereNaLista(String nome){
        listaItens.add(nome);
        listaItensAdapter.notifyDataSetChanged();
    }

    protected void inicializaComponentes(){

        insereNomeEditView = findViewById(R.id.IDeditTextEntrada);
        insereNomeButton   = findViewById(R.id.IDInserreButton);

        listaItensListView = findViewById(R.id.IDlistView);
        listaItens         = new ArrayList<String>();
        listaItensAdapter  = new ArrayAdapter<String>(this,
                                                      android.R.layout.simple_expandable_list_item_1,
                                                      listaItens);
        listaItensListView.setAdapter(listaItensAdapter);

        selected = findViewById(R.id.IDtextViewSEL);
    }

    protected void inicializaListeners(){
        insereNomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome  = insereNomeEditView.getText().toString();
                insereNaLista(nome);
            }
        });

        listaItensListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = (String) adapterView.getItemAtPosition(i);
                selected.setText("Item: " + s);

            }
        });

    }

}
