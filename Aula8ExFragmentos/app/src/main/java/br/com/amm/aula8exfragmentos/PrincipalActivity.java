package br.com.amm.aula8exfragmentos;

import android.app.Fragment;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PrincipalActivity extends AppCompatActivity
                            implements PrimeiroFragment.OnFragmentInteractionListener,
                                       SegundoFragment.OnFragmentInteractionListener{

    private EditText strFrag1;
    private EditText numFrag2;
    private Button enviaFrag1Button;
    private Button enviaFrag2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        strFrag1 = (EditText) findViewById(R.id.IDeditTextFrag1);
        numFrag2 = (EditText) findViewById(R.id.IDeditTextFrag2);
        enviaFrag1Button = (Button) findViewById(R.id.IDbuttonEnvia1);
        enviaFrag2Button = (Button) findViewById(R.id.IDbuttonEnvia2);
        enviaFrag1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrimeiroFragment f1;
                f1 = (PrimeiroFragment) getSupportFragmentManager().findFragmentById(R.id.IDfragment1);
                f1.setStringFrag(strFrag1.getText().toString());
            }
        });
        enviaFrag2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SegundoFragment f2;
                f2 = (SegundoFragment) getSupportFragmentManager().findFragmentById(R.id.IDfragment2);
                f2.setNumFrag2(Integer.parseInt(numFrag2.getText().toString()));
            }
        });
    }

    @Override
    public void recebidoFragmento2(int numero) {
        numFrag2.setText(Integer.toString(numero));
    }
    @Override
    public void recebidoFragmento1(String texto) {
        strFrag1.setText(texto);
    }
    @Override
    public int enviaFragmento2() {
        return Integer.parseInt(numFrag2.getText().toString());
    }
    @Override
    public String enviaFragmento1() {
        return strFrag1.getText().toString();
    }
}
