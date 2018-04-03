package br.com.amm.aula4ex1;

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

public class JheActivity extends AppCompatActivity {

    private EditText nomeProduto;
    private Button   insereProduto;
    private TextView resultadoProduto;
    //Esses sao para a ListView
    private ListView             listaProduto;
    private ArrayList<String>    arrayListProduto;
    private ArrayAdapter<String> arrayListAdpterProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jhe);
        //Inicializar Componentes
        nomeProduto = (EditText) findViewById(R.id.editTextNome);
        insereProduto = (Button) findViewById(R.id.buttonINSERE);
        resultadoProduto = (TextView) findViewById(R.id.textViewRESULTADO);


        listaProduto = (ListView) findViewById(R.id.listViewPRODUTO);
        arrayListProduto = new ArrayList<String>();
        arrayListAdpterProduto = new ArrayAdapter<String>(this,
                                  android.R.layout.simple_expandable_list_item_1,
                                  arrayListProduto);
        listaProduto.setAdapter(arrayListAdpterProduto);
        //Inicializar Listeners -------------------
        // Esse é o do botao
        insereProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempNome = nomeProduto.getText().toString();
                arrayListProduto.add(tempNome);
                arrayListAdpterProduto.notifyDataSetChanged();
            }
        });
        // Agora o do Item clicado
        listaProduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String tempNome = (String) adapterView.getItemAtPosition(i);
                resultadoProduto.setText("Nome selecionado :" +tempNome);
            }
        });
    }
}
