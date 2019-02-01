package br.com.amm.aula1ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Aula1Ex1Activity extends AppCompatActivity {
    private TextView helloTextView;
    private TextView frase2TextView;
    private Button trocaTextoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula1_ex1);
        helloTextView =(TextView)findViewById(R.id.IDhelloTextView);
        frase2TextView = (TextView) findViewById(R.id.IDfrase2textView);
         trocaTextoButton = (Button) findViewById(R.id.IDTrocaTextobutton);
          trocaTextoButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  helloTextView.setText("Eu odeio o Android Studio");
                  frase2TextView.setText("E o anuncio da Trivago Também!!!!");
              }
          });







    }
}
