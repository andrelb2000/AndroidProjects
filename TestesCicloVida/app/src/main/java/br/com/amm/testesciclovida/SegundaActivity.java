package br.com.amm.testesciclovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {
    private Button act1Button;
    private Intent act1Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        act1Button = (Button) findViewById(R.id.ID2_ACT2_button);
        act1Intent = new Intent(this,PrimeiraActivity.class);
        System.out.println("Activity 2 - OnCreate");
        act1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Activity 2 - Before startActivity");
                startActivity(act1Intent);
                System.out.println("Activity 2 - After startActivity");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Activity 2 - OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Activity 2 - OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Activity 2 - OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Activity 2 - OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Activity 2 - OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Activity 2 - OnRestart");
    }

}
