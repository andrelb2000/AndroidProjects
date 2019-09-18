package br.com.amm.aula6ex1_filme_itemlistener;

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

public class MainActivity extends AppCompatActivity {
    private EditText nomeFilmeEditText;
    private EditText atorEditText;
    private EditText diaEditText;
    private EditText mesEditText;
    private EditText anoEditText;

    private Button   insereButton;
    private Button   listaButton;
    private Button   limpaButton;

    private ListView             listaFilmeListView;
    private ArrayList<Filme>     listaFilme;
    private ArrayAdapter<Filme>  listaFilmeArrayAdapter;

      private Intent   detalheIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        inicializaListeners();
    }

    protected void inicializaComponentes(){
        nomeFilmeEditText = (EditText) findViewById(R.id.ID1_FILMEeditText);
        atorEditText      = (EditText) findViewById(R.id.ID1_ATOR_editText2);
        diaEditText       = (EditText) findViewById(R.id.ID1_DIAeditText4);
        mesEditText       = (EditText) findViewById(R.id.ID1_MESeditText5);
        anoEditText       = (EditText) findViewById(R.id.ID1_ANOeditText6);

        insereButton     = (Button) findViewById(R.id.ID1_INSEREbutton);
        listaButton      = (Button) findViewById(R.id.ID1_LISTAbutton2);
        limpaButton      = (Button) findViewById(R.id.ID1_LIMPAbutton3);

        listaFilmeListView      = (ListView) findViewById(R.id.ID1_LISTAListView);
        listaFilme              = new ArrayList<Filme>();
        listaFilmeArrayAdapter  = new ArrayAdapter<Filme>(this,
                                          android.R.layout.simple_list_item_1,
                                          listaFilme);
        listaFilmeListView.setAdapter(listaFilmeArrayAdapter);

        detalheIntent = new Intent(this,DetalheFilmeActivity.class);
    }
    protected void inicializaListeners(){
        //////////////
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filme = nomeFilmeEditText.getText().toString();
                String ator  = atorEditText.getText().toString();
                String data  = diaEditText.getText().toString() + "/" +
                               mesEditText.getText().toString() + "/" +
                               anoEditText.getText().toString();
                Filme f = new Filme(filme,ator,data);
                listaFilme.add(f);
            }
        });
        /////////////
        listaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaFilmeArrayAdapter.notifyDataSetChanged();
            }
        });
        //////////////
        limpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaFilme.clear();
                listaFilmeArrayAdapter.notifyDataSetChanged();
            }
        });
        ////////////
        listaFilmeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Filme f = (Filme) parent.getItemAtPosition(position);
                Bundle trouxa = new Bundle();
                    trouxa.putString("FILME",f.getNomeFilme());
                    trouxa.putString("ATOR",f.getAtorFilme());
                    trouxa.putString("DATA",f.getDataFilme());

                detalheIntent.putExtras(trouxa);

                startActivity(detalheIntent);
            }
        });

    }


}
