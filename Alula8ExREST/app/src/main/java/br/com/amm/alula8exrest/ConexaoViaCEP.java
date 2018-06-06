package br.com.amm.alula8exrest;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.EditText;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ConexaoViaCEP {
    private URL url = null;
    private HttpsURLConnection conexao = null;
    private String urlServico;
    private JsonReader readerREST = null;
    private boolean conectado = false;

    public ConexaoViaCEP(String urlBase, String parametro){
            urlServico = urlBase + parametro + "/json/";
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        url = new URL(urlServico);
                        
                        conexao = (HttpsURLConnection) url.openConnection();
                        conexao.connect();
                        int respCode = conexao.getResponseCode();
                        if(respCode==200) {
                            InputStream is = url.openStream();
                            Reader sr = new InputStreamReader(is);
                            readerREST = new JsonReader(sr);
                            conectado = true;
                        }
                    }catch (Exception e){
                        System.out.println("Errro:" + e);
                        conectado = false;
                    }
                }
            });
    }
    public boolean isConectado() {
        return conectado;
    }
    public void fecharConexao(){
        if(conectado){
            conexao.disconnect();
        }
    }
    public JsonReader getReader(){
        return readerREST;
    }
}
