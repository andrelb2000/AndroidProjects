package br.com.amm.baseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        TextView st = findViewById(R.id.editTextDataShow);
        st.setText(b.getString("NOME"));


    }
}
