package br.com.amm.testesciclovida;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrimeiraActivity extends AppCompatActivity {
    private Button act2Button;
    private Button diagButton;
    private Intent act2Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
        act2Button = (Button) findViewById(R.id.ID1_Act2button);
        diagButton = (Button) findViewById(R.id.ID1DIAGbutton2);
        act2Intent = new Intent(this,SegundaActivity.class);
        System.out.println("Activity 1 - OnCreate");

        act2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Activity 1 - Before startActivity");
                startActivity(act2Intent);
                System.out.println("Activity 1 - After startActivity");
            }
        });
        diagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Checando Pause");
                builder.setMessage("Click Ok para voltar");
                builder.setNeutralButton("OK",null);
                builder.create();
                builder.show();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Activity 1 - OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Activity 1 - OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Activity 1 - OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Activity 1 - OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Activity 1 - OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Activity 1 - OnRestart");
    }
}
