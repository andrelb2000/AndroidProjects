package com.example.aula6ex1_temperaturasqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private EditText nomeSensorEditText;
    private EditText codSensorEditText;
    private EditText tempSensorEditText;
    private EditText mediaSensoresEditText;
    private Button   insereButton;
    private Button   carregaButton;
    private Button   mediaButton;

    /// Santa trindade
    private ListView             sensoresListView;
    private ArrayList<Sensor>    listaSensores;
    private ArrayAdapter<Sensor> sensorArrayAdapter;

    private SGBD  gerenciadorBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gerenciadorBanco = new SGBD(this);

        inicializaComponentes();
        inicializaListeners();
        /// Inicializar Banco de Dados (aguarde)

    }
    protected void inicializaComponentes(){
        nomeSensorEditText     = (EditText) findViewById(R.id.ID1_NOMEeditText);
        codSensorEditText      = (EditText) findViewById(R.id.ID1_CODeditText2);
        tempSensorEditText     = (EditText) findViewById(R.id.ID1_TEMPeditText3);
        mediaSensoresEditText  = (EditText) findViewById(R.id.ID1_MEDIATEMPeditText4);

        insereButton           = (Button)   findViewById(R.id.ID1_INSEREbutton);
        carregaButton          = (Button)   findViewById(R.id.ID1_CARREGAbutton2);
        mediaButton            = (Button)   findViewById(R.id.ID1_MEDIAbutton3);

        sensoresListView       = (ListView) findViewById(R.id.ID1_SENSORListView);
        listaSensores          =  new ArrayList<Sensor>();
        sensorArrayAdapter     =  new ArrayAdapter<Sensor>(this,
                                            android.R.layout.simple_list_item_1,
                                            listaSensores);
        sensoresListView.setAdapter(sensorArrayAdapter);
    }
    protected void inicializaListeners(){
        //////
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeSensorEditText.getText().toString();
                int    cod  = Integer.parseInt(codSensorEditText.getText().toString());
                double temp = Double.parseDouble(tempSensorEditText.getText().toString());
                Sensor s = new Sensor(nome,cod,temp);
                listaSensores.add(s);
                sensorArrayAdapter.notifyDataSetChanged();
                gerenciadorBanco.insereSensor(s);
                listaSensores.
            }

        });
        ////////////
        carregaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaSensores.clear();
                gerenciadorBanco.recuperaSensores(listaSensores);
                sensorArrayAdapter.notifyDataSetChanged();
            }
        });
        //////
        mediaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double media = 0;
                int    nrSensores = 0;
                Iterator<Sensor> it = listaSensores.iterator();
                while (it.hasNext()){
                    Sensor s = it.next();
                    media += s.getTempSensor();
                    nrSensores++;
                }
                media = media / nrSensores;
                mediaSensoresEditText.setText(Double.toString(media));
            }
        });
    }


}
