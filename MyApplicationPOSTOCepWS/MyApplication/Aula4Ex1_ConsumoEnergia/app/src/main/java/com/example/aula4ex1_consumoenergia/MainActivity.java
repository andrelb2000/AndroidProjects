package com.example.aula4ex1_consumoenergia;

import android.renderscript.Script;
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
    private EditText usuarioEditText;
    private EditText equipamentoEditText;
    private EditText consumoEditText;
    private EditText totalEditText;

    private Button   insereButton;
    private Button   calculaButton;

    private ListView                  listaListView;
    private ArrayList<Equipamento>    lista;
    private ArrayAdapter<Equipamento> listaArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        inicializaListeners();
    }
    private void inicializaComponentes(){
        usuarioEditText      = findViewById(R.id.ID1_USUARIOeditText);
        equipamentoEditText  = findViewById(R.id.ID1_EQUIPAMENTOeditText2);
        consumoEditText      = findViewById(R.id.ID1_CONSUMOeditText3);
        totalEditText        = findViewById(R.id.ID1_TOTALeditText4);
        insereButton         = findViewById(R.id.ID1_INSEREbutton);
        calculaButton        = findViewById(R.id.ID1_CALCULAbutton2);

        listaListView       = findViewById(R.id.ID1_LISTAListView);
        lista               = new ArrayList<Equipamento>();
        listaArrayAdapter   = new ArrayAdapter<Equipamento>(this,
                android.R.layout.simple_expandable_list_item_1,
                lista);
        listaListView.setAdapter(listaArrayAdapter);
    }
    private void inicializaListeners(){
        insereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario     = usuarioEditText.getText().toString();
                String equipamento = equipamentoEditText.getText().toString();
                int    consumo     = Integer.parseInt(consumoEditText.getText().toString());
                Equipamento equipamento1 = new Equipamento(usuario,equipamento,consumo);
                lista.add(equipamento1);
                listaArrayAdapter.notifyDataSetChanged();
            }
        });
        calculaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calcular total de consumo de todos os equipamentos //
                int totalConsumo = 0;
                Iterator<Equipamento> it = lista.iterator();
                while (it.hasNext()){
                    Equipamento e = it.next();
                    totalConsumo+= e.getConsumoEquipamento();
                }
                double tarifa = Double.parseDouble(totalEditText.getText().toString());
                double totalGasto = tarifa * totalConsumo;
                totalEditText.setText("R$ " + totalGasto);
            }
        });


    }



}
