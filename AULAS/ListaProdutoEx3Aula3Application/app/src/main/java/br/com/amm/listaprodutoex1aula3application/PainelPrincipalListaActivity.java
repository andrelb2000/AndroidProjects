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
    private ArrayList<Produto>    listaItens = null;
    private ArrayAdapter<Produto> listaItensAdapter = null;

    private TextView selected   = null;

    private EditText qdeEditText = null;
    private EditText custoUnit   = null;
    private EditText precoVenda  = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_principal_lista);
        inicializaComponentes();
        inicializaListeners();
    }

    public void insereNaLista(String nome,int qde, double custo, double venda){
        Produto p = new Produto(nome,custo,venda);
        p.setQuantidadeVenda(qde);
        listaItens.add(p);
        listaItensAdapter.notifyDataSetChanged();
    }

    protected void inicializaComponentes(){

        insereNomeEditView = findViewById(R.id.IDeditTextEntrada);
        insereNomeButton   = findViewById(R.id.IDInserreButton);

        listaItensListView = findViewById(R.id.IDlistView);
        listaItens         = new ArrayList<Produto>();
        listaItensAdapter  = new ArrayAdapter<Produto>(this,
                                                      android.R.layout.simple_expandable_list_item_1,
                                                      listaItens);
        listaItensListView.setAdapter(listaItensAdapter);

        selected = findViewById(R.id.IDtextViewSEL);

        qdeEditText = (EditText) findViewById(R.id.IDeditTextQde);
        custoUnit   = (EditText) findViewById(R.id.IDeditTextCusto);
        precoVenda  = (EditText) findViewById(R.id.IDeditTextVenda);

    }



    protected void inicializaListeners(){
        insereNomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeproduto  = insereNomeEditView.getText().toString();
                int  qde = Integer.parseInt(qdeEditText.getText().toString());
                double custo = Double.parseDouble(custoUnit.getText().toString());
                double venda = Double.parseDouble(precoVenda.getText().toString());

                insereNaLista(nomeproduto,qde,custo,venda);
            }
        });

        listaItensListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produto p = (Produto) adapterView.getItemAtPosition(i);
                selected.setText(p + " - Venda R$ "+p.totalVenda() + " - Lucro R$ " + p.lucroTotal() );

            }
        });

    }

}
