package br.com.amm.alula8exrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.widget.Toast.makeText;

public class BuscaPorCEPActivity extends AppCompatActivity
                                implements CEPFragment.OnFragmentInteractionListener{

    private EditText cepEditText, logEditText, compEditText,bairroEditText,
                     cidadeEditText, ufEditText;
    private Button   buscaLog;
    private String VIACEP =  "https://viacep.com.br/ws/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_por_cep);
            cepEditText    = (EditText) findViewById(R.id.IDeditTextCEP);
            logEditText    = (EditText) findViewById(R.id.IDeditTextRUA);
            compEditText   = (EditText) findViewById(R.id.IDeditTextComp);
            bairroEditText = (EditText) findViewById(R.id.IDeditTextBAIRRO);
            cidadeEditText = (EditText) findViewById(R.id.IDeditTextCIDADE);
            ufEditText     = (EditText) findViewById(R.id.IDeditTextUF);
            buscaLog    = (Button)   findViewById(R.id.IDbuttonCEP);

        buscaLog.setOnClickListener(new View.OnClickListener() {
            String logradouro, comp, bairro, cidade, uf;
            @Override
            public void onClick(View view) {
                ConexaoViaCEP ccx = new ConexaoViaCEP(VIACEP,cepEditText.getText().toString());
                try{
                    while(!ccx.isConectado()){
                        Thread.sleep(1000);
                    }
                    JsonReader jr = ccx.getReader();
                    jr.beginObject();
                    if(jr.hasNext()){
                        //Ex:  "cep":        "20510-150",
                        jr.nextName();       jr.skipValue();
                        //Ex: "logradouro": "Rua Itacuruçá",
                        jr.nextName();      logradouro = jr.nextString();
                        //Ex:"complemento": "",
                        jr.nextName();      comp = jr.nextString();
                        //Ex: "bairro":     "Tijuca",
                        jr.nextName();      bairro = jr.nextString();
                        //Ex: "localidade": "Rio de Janeiro",
                        jr.nextName();      cidade = jr.nextString();
                        //Ex: "uf":         "RJ",
                        jr.nextName();      uf = jr.nextString();

                        logEditText.setText(logradouro);
                        compEditText.setText(comp);
                        bairroEditText.setText(bairro);
                        cidadeEditText.setText(cidade);
                        ufEditText.setText(uf);
                    }
                    ccx.fecharConexao();
                }catch (Exception ioe){
                    System.out.println("Errro:" + ioe);
                }


            }
        });
    }

    @Override
    public void colocaLogradouro(String l) {
        logEditText.setText(l);
    }
    @Override
    public void colocaComp(String complemento) {
        compEditText.setText(complemento);
    }
    @Override
    public void colocaBairro(String bairro) {
        bairroEditText.setText(bairro);
    }
    @Override
    public void colocaCidade(String cidade) {
        cidadeEditText.setText(cidade);
    }
    @Override
    public void colocaUF(String UF) {
        ufEditText.setText(UF);
    }
}
