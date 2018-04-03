package br.com.amm.aula5ex1_alertas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PainelAlertasActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;

    private EditText edt1;
    private EditText edt5;

    private TextView txtV2;
    private TextView txtV3;
    private TextView txtV4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_alertas);
        b1 = (Button)findViewById(R.id.IDbutton0);
        b2 = (Button)findViewById(R.id.IDbutton2);
        b3 = (Button)findViewById(R.id.IDbutton3);
        b4 = (Button)findViewById(R.id.IDbutton4);
        b5 = (Button)findViewById(R.id.IDbutton5);

        edt1 = (EditText)findViewById(R.id.IDeditText0);
        edt5 = (EditText)findViewById(R.id.IDeditText5);
        txtV2 = (TextView)findViewById(R.id.IDtextView2);
        txtV3 = (TextView)findViewById(R.id.IDtextView3);
        txtV4 = (TextView)findViewById(R.id.IDtextView4);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                builder1.setTitle("Alert Dialog 1");
                builder1.setMessage(edt1.getText());
                builder1.create();
                builder1.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(view.getContext());
                builder2.setTitle("Alert Dialog 2");
                builder2.setMessage(edt1.getText());
                builder2.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtV2.setText("Botao SIM");
                    }
                });
                builder2.setNegativeButton("NAO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtV2.setText("Botao NAO");
                    }
                });
                builder2.create();
                builder2.show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(view.getContext());
                builder3.setTitle("Alert Dialog 3");
                builder3.setMessage("Botoes que nao fazem nada");
                builder3.setPositiveButton("Sim",null);
                builder3.setNegativeButton("Nao",null);
                builder3.setNeutralButton("Tanto Faz",null);
                txtV3.setText("Faz nada");
                builder3.create();
                builder3.show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast msgToast = Toast.makeText(view.getContext(),
                        edt5.getText(),
                        Toast.LENGTH_LONG);
                msgToast.setGravity(Gravity.CENTER,
                                    msgToast.getXOffset()/2,
                                    msgToast.getYOffset()/2);
                txtV4.setText("Posicionando");
                msgToast.show();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast msgToast = Toast.makeText(view.getContext(),
                                                edt5.getText(),
                                                Toast.LENGTH_LONG);
                msgToast.show();
            }
        });













    }
}
