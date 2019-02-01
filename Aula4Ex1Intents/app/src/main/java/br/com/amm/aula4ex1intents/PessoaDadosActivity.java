package br.com.amm.aula4ex1intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PessoaDadosActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private EditText cepEditText;
    private EditText numEditText;
    private EditText aptEditText;
    private EditText telEditText;
    private Button   enviaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_dados);

        nomeEditText = (EditText) findViewById(R.id.IDNomeEditText);
        cepEditText  = (EditText) findViewById(R.id.IDCEPeditText);
        numEditText  = (EditText) findViewById(R.id.IDNumEditText);
        aptEditText  = (EditText) findViewById(R.id.IDAPTeditText);
        telEditText  = (EditText) findViewById(R.id.IDTelEditText);
        enviaButton  = (Button)   findViewById(R.id.IDEnviaButton);
        enviaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////// Nosso Codigo ////////////
                criarNovaActivity();
                ////////////////////////////////
            }
        });
    }
    public void criarNovaActivity(){
        Intent novaActivityIntent = new Intent(this,MostraDadosActivity.class);
        /// Criar "Pacote" para envio dos dados ///
        Bundle dadosEnviados = new Bundle();
        /// Colocar dado com uma "Chave", no caso "NOME" ////
        dadosEnviados.putString("NOME",nomeEditText.getText().toString());
        // Colocar o pacote na INTENT
        novaActivityIntent.putExtras(dadosEnviados);
        // Disparar a Intent //
        startActivity(novaActivityIntent);
    }
}
