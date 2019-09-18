package com.example.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText cepEditText;
    private EditText ruaEditText;
    private Button   insereButton;
    private Button   apagaButton;
    private Button   alteraButton;
    private Button   carregaButton;
    private Button   cepButton;

    private ListView            listaPostoListView;
    private ArrayList<Posto>    listaPosto;
    private ArrayAdapter<Posto> listaPostoArrayAdapter;

    private BancoPosto   bancoPosto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bancoPosto = new BancoPosto(this);
        inicializaComponentes();
        inicializarListeners();
    }
    protected Posto obterPostoDigitado(){
        String nome = nomeEditText.getText().toString();
        String cep  = cepEditText.getText().toString();
        String rua  = ruaEditText.getText().toString();
        Posto posto = new Posto(nome,cep,rua);
        return posto;
    }
    protected void inicializaComponentes(){
        nomeEditText  = findViewById(R.id.ID1_NOMEeditText);
        cepEditText   = findViewById(R.id.ID1_CEPeditText2);
        ruaEditText   = findViewById(R.id.ID1_RUAeditText3);
        insereButton  = findViewById(R.id.ID1_INSEREbutton2);
        apagaButton   = findViewById(R.id.ID1_APAGAbutton3);
        alteraButton  = findViewById(R.id.ID1_ALTERAbutton4) ;
        carregaButton = findViewById(R.id.ID1_CARREGAbutton5);
        cepButton     = findViewById(R.id.ID1_CEPbutton);

        listaPostoListView     = findViewById(R.id.ID1_LISTAListView);
        listaPosto             = new ArrayList<Posto>();
        listaPostoArrayAdapter = new ArrayAdapter<Posto>(this,
                                     android.R.layout.simple_list_item_1,
                                     listaPosto);
        listaPostoListView.setAdapter(listaPostoArrayAdapter);
    }
    protected void inicializarListeners(){
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posto posto = obterPostoDigitado();
                //1 - Inserir na lista
                listaPosto.add(posto);
                listaPostoArrayAdapter.notifyDataSetChanged();
                //2 - Inserir no Banco
                bancoPosto.inserePosto(posto);
            }
        });
        carregaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPosto.clear();
                bancoPosto.carregaListaPosto(listaPosto);
                listaPostoArrayAdapter.notifyDataSetChanged();
            }
        });
        apagaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posto posto = obterPostoDigitado();
                bancoPosto.apagarPosto(posto);
                listaPosto.clear();
                bancoPosto.carregaListaPosto(listaPosto);
                listaPostoArrayAdapter.notifyDataSetChanged();
            }
        });
        alteraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posto posto = obterPostoDigitado();
                bancoPosto.alteraPosto(posto);
                listaPosto.clear();
                bancoPosto.carregaListaPosto(listaPosto);
                listaPostoArrayAdapter.notifyDataSetChanged();
            }



        });
        cepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        Posto posto = obterPostoDigitado();
                        String VIACEP = "http://viacep.com.br/ws/";
                        String ws = VIACEP + obterPostoDigitado().getCepPosto() +"/json";
                        URL url = new URL(ws);
                        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
                        connection.connect();
                        InputStream is = url.openStream();
                        Reader r = new InputStreamReader(is);
                        JsonReader js = new JsonReader(r);
                        js.beginObject();
                            if(js.hasNext()){
                                js.nextName();js.skipValue();
                                js.nextName();
                                String rua = js.nextString();
                                ruaEditText.setText(rua);
                            }
                    }
                });



            }
        });

    }
}
