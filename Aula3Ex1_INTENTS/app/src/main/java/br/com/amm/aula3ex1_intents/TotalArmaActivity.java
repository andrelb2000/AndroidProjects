package br.com.amm.aula3ex1_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TotalArmaActivity extends AppCompatActivity {
    private TextView totalTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_arma);
        totalTextView = (TextView) findViewById(R.id.ID2_TOTALtextView6);
        Intent pai = getIntent();
        Bundle trouxa2;

        trouxa2 = pai.getExtras();

        double total = trouxa2.getDouble("TOTAL");

        totalTextView.setText("Preço total R$ "+total);

    }
}
