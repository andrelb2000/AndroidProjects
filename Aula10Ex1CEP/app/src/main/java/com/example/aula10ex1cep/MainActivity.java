package com.example.aula10ex1cep;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private EditText nomePostoEditText;
    private EditText ruaPostoEditText;
    private EditText cepEditText;
    private Button   cepButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomePostoEditText = findViewById(R.id.ID1_POSTOeditText);
        ruaPostoEditText  = findViewById(R.id.ID1_RUAeditText2) ;
        cepEditText       = findViewById(R.id.ID1_CEPeditText3);
        cepButton         = findViewById(R.id.ID1_CEPbutton);

        cepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            String urlBase = "https://viacep.com.br/ws/";
                            String cep = cepEditText.getText().toString();
                            String url = urlBase + cep + "/json/";
                            URL    connURL = new URL(url);
                            HttpsURLConnection connection = (HttpsURLConnection) connURL.openConnection();
                            connection.connect();
                            int respCode = connection.getResponseCode();
                            if(respCode==200){
                                InputStream is = connURL.openStream();
                                Reader r = new InputStreamReader(is);
                                JsonReader jr = new JsonReader(r);
                                jr.beginObject();
                                 // cep	"20550-040"
                                 jr.nextName();  jr.skipValue();
                                 //logradouro	"Rua Almirante Cochrane"
                                 jr.nextName();
                                 String rua = jr.nextString();
                                 ruaPostoEditText.setText(rua);
                            }
                        }catch (Exception e){
                            System.out.println("Erro de rede "+e);

                        }
                    }
                });












            }
        });




    }


}
