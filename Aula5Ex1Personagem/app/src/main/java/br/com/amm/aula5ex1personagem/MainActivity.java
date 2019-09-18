package br.com.amm.aula5ex1personagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText personagemEditText;
    private EditText forcaEditText;
    private EditText dinheiroEditText;

    private Button   insereButton;
    private Button   listaButton;
    private Button   limpaButton;

    private ListView                  listaPersonagemListView;
    private ArrayList<Personagem>     listaPersonagem;
    private ArrayAdapter<Personagem>  personagemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        inicializarListeners();

    }

    public void inicializarComponentes(){
        personagemEditText  = (EditText) findViewById(R.id.ID1_NOMEeditText);
        forcaEditText       = (EditText) findViewById(R.id.ID1_FORCAeditText2);
        dinheiroEditText    = (EditText) findViewById(R.id.ID1_MONEYeditText3);
        insereButton        = (Button)   findViewById(R.id.ID1_INSEREbutton);
        listaButton         = (Button)   findViewById(R.id.ID1_LISTAbutton2) ;
        limpaButton         = (Button)   findViewById(R.id.ID1_LIMPAbutton3);

        listaPersonagemListView  = (ListView) findViewById(R.id.ID1_LISTAListView);
        listaPersonagem          = new ArrayList<Personagem>();
        personagemArrayAdapter   = new ArrayAdapter<Personagem>(this,
                                         android.R.layout.simple_list_item_1,
                                         listaPersonagem);
        listaPersonagemListView.setAdapter(personagemArrayAdapter);

    }
    public void inicializarListeners(){

        ////////////////////
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome     = personagemEditText.getText().toString();
                int    forca    = Integer.parseInt(forcaEditText.getText().toString());
                double dinheiro = Double.parseDouble(dinheiroEditText.getText().toString());
                Personagem p = new Personagem(nome,forca,dinheiro);
                listaPersonagem.add(p);
            }
        });
        ///////////////////
        listaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personagemArrayAdapter.notifyDataSetChanged();
            }
        });

        ////////////////
        limpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPersonagem.clear();
                personagemArrayAdapter.notifyDataSetChanged();
            }
        });




    }

}
