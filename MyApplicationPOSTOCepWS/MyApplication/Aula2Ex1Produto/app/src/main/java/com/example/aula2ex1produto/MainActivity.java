package com.example.aula2ex1produto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nomeProdutoEditText;
    private EditText precoProdutoEditText;
    private EditText descontoProdutoEditText;
    private TextView totalTextView;
    private Button   addButton;
    private double precoTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        precoProdutoEditText     = findViewById(R.id.ID1_PRECOeditText2);
        descontoProdutoEditText  = findViewById(R.id.ID1_DESCONTOeditText3);
        totalTextView            = findViewById(R.id.ID1_TOTALtextView5);
        nomeProdutoEditText      = findViewById(R.id.ID1_PRODUTOeditText);
        addButton                = findViewById(R.id.ID1_ADDbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double preco     = Double.parseDouble(precoProdutoEditText.getText().toString());
                double desconto  = Double.parseDouble(descontoProdutoEditText.getText().toString());
                ////////////
                ProdutoModelo p = new ProdutoModelo(nomeProdutoEditText.getText().toString(),
                                                    preco,
                                                    desconto);
                precoProdutoEditText.setText(Double.toString(p.getPrecoProduto()));
                precoTotal += p.getPrecoProduto();
                /////////////////

                totalTextView.setText(Double.toString(precoTotal));
            }
        });




    }
}
