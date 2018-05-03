package br.com.amm.aula6ex1sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdutoActivity extends AppCompatActivity {
    private EditText nomeProdEditText;
    private EditText precoProdEditText;

    private ListView produtoListView;
    private ArrayList<Produto> listaProduto;
    private ArrayAdapter<Produto> adapterProduto;

    private ListView pesquisaListView;
    private ArrayList<Produto> listaPesquisa;
    private ArrayAdapter<Produto> adapterPesquisa;


    private Button insereButton;
    private Button carregaButton;
    private Button cleanButton;

    private Button pesquisarButton;

    private Button limpaListaButton;
    private Button updateButton;
    private Button deleteButton;


    private GerenteBanco gerenteBanco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        inicializarComponentes();
        inicializarListener();
        gerenteBanco = new GerenteBanco(this);
    }
    protected void inicializarComponentes(){
        nomeProdEditText  = (EditText)findViewById(R.id.IDeditTextNome);
        precoProdEditText = (EditText)findViewById(R.id.IDeditTextPreco);

        /// PASSOS PARA A LISTVIEW ///
        produtoListView = (ListView) findViewById(R.id.IDlistViewProduto);
        listaProduto = new ArrayList<Produto>();
        adapterProduto = new ArrayAdapter<Produto>(this,
                       android.R.layout.simple_expandable_list_item_1,
                       listaProduto);
        produtoListView.setAdapter(adapterProduto);
        ///////////////////////////////
        pesquisaListView = (ListView) findViewById(R.id.IDlistViewResult);
        listaPesquisa    = new ArrayList<Produto>();
        adapterPesquisa  = new ArrayAdapter<Produto>(this,
                android.R.layout.simple_expandable_list_item_1,
                listaPesquisa);
        pesquisaListView.setAdapter(adapterPesquisa);
        ///////////////////////////////

        insereButton  = (Button) findViewById(R.id.IDbuttonInserir);
        carregaButton = (Button) findViewById(R.id.IDbuttonCarregar);
        cleanButton   = (Button) findViewById(R.id.IDbuttonCLEAN);

        pesquisarButton = (Button) findViewById(R.id.IDbuttonPESQ);

        limpaListaButton = (Button) findViewById(R.id.IDbuttonLimparLista);
        updateButton     = (Button) findViewById(R.id.IDbuttonUPDATE);
        deleteButton     = (Button) findViewById(R.id.IDbuttonDELETAR);
    }

    public void inicializarListener(){
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////
                String tempNome = nomeProdEditText.getText().toString();
                String precoString = precoProdEditText.getText().toString();
                double tempPreco = Double.parseDouble(precoString);
                Produto p = new Produto(tempNome,tempPreco);
                listaProduto.add(p);
                try{
                    insereBanco(p);
                }catch (Exception e){
                    //// codigo alerta
                }
                adapterProduto.notifyDataSetChanged();
            }
        });
        carregaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    listaProduto.clear();
                    adapterProduto.clear();
                    selectAll();
                    adapterProduto.notifyDataSetChanged();
                }catch (Exception e){
                }
            }
        });

        pesquisarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    listaPesquisa.clear();
                    adapterPesquisa.clear();
                    select(nomeProdEditText.getText().toString());
                    adapterPesquisa.notifyDataSetChanged();
                }catch (Exception e){
                }
            }
        });

        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    listaProduto.clear();
                    adapterProduto.clear();
                    adapterProduto.notifyDataSetChanged();

                    listaPesquisa.clear();
                    adapterPesquisa.clear();
                    adapterPesquisa.notifyDataSetChanged();

                    cleanTable(GerenteBanco.NOME_TABELA);
                }catch (Exception e){
                }
            }
        });

        limpaListaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaProduto.clear();
                adapterProduto.clear();
                adapterProduto.notifyDataSetChanged();

                listaPesquisa.clear();
                adapterPesquisa.clear();
                adapterPesquisa.notifyDataSetChanged();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    listaProduto.clear();
                    adapterProduto.clear();
                    deleteProduto(GerenteBanco.NOME_TABELA,
                            nomeProdEditText.getText().toString());
                    selectAll();
                    adapterProduto.notifyDataSetChanged();
                }catch (Exception e){
                }
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String tempNome = nomeProdEditText.getText().toString();
                    String precoString = precoProdEditText.getText().toString();
                    double tempPreco = Double.parseDouble(precoString);
                    Produto p = new Produto(tempNome,tempPreco);
                    listaProduto.clear();
                    adapterProduto.clear();
                    updateProduto(GerenteBanco.NOME_TABELA,
                                nomeProdEditText.getText().toString(),
                                p);
                    selectAll();
                    adapterProduto.notifyDataSetChanged();
                }catch (Exception e){
                }
            }
        });


    }

    protected void cleanTable(String table) throws Exception{
        SQLiteDatabase db = gerenteBanco.getWritableDatabase();
        db.delete(table, null,null);
        db.close();
    }


    protected void deleteProduto(String table,String nome) throws Exception{
        SQLiteDatabase db = gerenteBanco.getWritableDatabase();
            /// Acrescentando Clausula WHERE ///
            String where = "NOME = ?";
            /// Acrescentando a parte que vai na "?" ///
            String[] varInterrogacao = new String[1];
            varInterrogacao[0] = nome;
            db.delete(table,where,varInterrogacao);
        db.close();
    }

    protected void updateProduto(String table,String nome,
                                 Produto p) throws Exception{
        SQLiteDatabase db = gerenteBanco.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("NOME",p.getNomeProduto());
            reg.put("PRECO",p.getPrecoProduto());

            /// Acrescentando Clausula WHERE ///
            String where = "NOME = ?";
            /// Acrescentando a parte que vai na "?" ///
            String[] varInterrogacao = new String[1];
            varInterrogacao[0] = nome;
            db.update(table,reg,where,varInterrogacao);
        db.close();
    }




    protected void insereBanco(Produto p) throws Exception{
        SQLiteDatabase db = gerenteBanco.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("NOME",p.getNomeProduto());
        reg.put("PRECO",p.getPrecoProduto());
        db.insert(GerenteBanco.NOME_TABELA,null,reg);
        db.close();
    }
    protected void selectAll() throws Exception{
        SQLiteDatabase db = gerenteBanco.getReadableDatabase();
        Cursor c = null;
        String[] coluna = new String[2];
        coluna[0] = "NOME";
        coluna[1] = "PRECO";
        c = db.query(GerenteBanco.NOME_TABELA,coluna,null,null,null,null,null);
        if(c==null){
            System.out.print("Nao retornou nada");
        }else{
            c.moveToFirst();
        }

        while (c!=null){
            String nome = c.getString(0);
            double preco = c.getDouble(1);
            Produto p = new Produto(nome,preco);
            listaProduto.add(p);
            c.moveToNext();
        }

        db.close();


    }

    protected void select(String nomepesquisar) throws Exception{
        SQLiteDatabase db = gerenteBanco.getReadableDatabase();
        Cursor c = null;
        String[] coluna = new String[2];
        coluna[0] = "NOME";
        coluna[1] = "PRECO";
        /// Acrescentando Clausula WHERE ///
        String where = "NOME = ?";
        /// Acrescentando a parte que vai na "?" ///
        String[] varInterrogacao = new String[1];
        varInterrogacao[0] = nomepesquisar;
        c = db.query(GerenteBanco.NOME_TABELA, // FROM   GerenteBanco.NOME_TABELA
                     coluna,                   // SELECT coluna[0],coluna[1]
                      where,                    // WHERE  = ?
                      varInterrogacao,          // ? --> varInterrogacao[0]
                      null,null,null);
        if(c.getCount() <=0){
            Toast.makeText(this,"Nao retornou nada",Toast.LENGTH_LONG);
        }else{
            c.moveToFirst();
            while (c!=null){
                String nome = c.getString(0);
                double preco = c.getDouble(1);
                Produto p = new Produto(nome,preco);
                listaPesquisa.add(p);
                c.moveToNext();
            }
        }
       db.close();
    }


}
