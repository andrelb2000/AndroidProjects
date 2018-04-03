package br.com.amm.baseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataInputActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);


        final Intent dataShowIntent = new Intent(this,DataShowActivity.class);

        final Bundle dados = new Bundle();
        Button b = (Button) findViewById(R.id.button_DATA_SHOW);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.editTextNome);
                dados.putString("NOME",tv.getText().toString());
                dataShowIntent.putExtras(dados);
                startActivity(dataShowIntent);
            }
        });


    }
}
