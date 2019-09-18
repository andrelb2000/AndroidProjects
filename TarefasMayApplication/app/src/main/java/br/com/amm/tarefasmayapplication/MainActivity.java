package br.com.amm.tarefasmayapplication;

import android.support.v4.widget.ListViewAutoScrollHelper;
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
    private EditText nomeTarefaEditText;
    private EditText prioridadeEditText;
    private TextView nrTarefasTextView;
    private Button   adicionarButton;

    /// Objetos para criacao de lista ///
    private ListView             listaTarefasListView;
    private ArrayList<String>    listaTarefas;
    private ArrayAdapter<String> listaTarefasArrayAdapter;


    private int  totalTarefas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomeTarefaEditText   = (EditText) findViewById(R.id.ID1_TAREFAeditText);
        prioridadeEditText   = (EditText) findViewById(R.id.ID1_PRIORIDADEeditText2);
        nrTarefasTextView    = (TextView) findViewById(R.id.ID1_NRTOTALtextView4);
        adicionarButton      = (Button)   findViewById(R.id.ID1_ADICIONARbutton) ;
        ////////////////////
        listaTarefasListView      = (ListView) findViewById(R.id.ID1_LISTAListView);
        listaTarefas              = new ArrayList<String>();
        listaTarefasArrayAdapter  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listaTarefas);
        listaTarefasListView.setAdapter(listaTarefasArrayAdapter);
         /////////////////////////////




        adicionarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String tarefa = nomeTarefaEditText.getText().toString();
                 int    prioridade = Integer.parseInt(prioridadeEditText.getText().toString());

                 listaTarefas.add(tarefa + " - "+prioridade);
                 listaTarefasArrayAdapter.notifyDataSetChanged();
                totalTarefas++;
                nrTarefasTextView.setText(Integer.toString(totalTarefas));
            }
        });

    }




}
