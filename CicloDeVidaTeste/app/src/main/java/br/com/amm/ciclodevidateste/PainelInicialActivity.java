package br.com.amm.ciclodevidateste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PainelInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_inicial);
        System.out.println(" --------------------------------------");
        System.out.println("     ACTIVITY PRINCIPAL - OnCreate");
        System.out.println(" --------------------------------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(" --------------------------------------");
        System.out.println("     ACTIVITY PRINCIPAL - OnStart");
        System.out.println(" --------------------------------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(" --------------------------------------");
        System.out.println("     ACTIVITY PRINCIPAL - OnResume");
        System.out.println(" --------------------------------------");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(" --------------------------------------");
        System.out.println("     ACTIVITY PRINCIPAL - OnRestart");
        System.out.println(" --------------------------------------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(" --------------------------------------");
        System.out.println("     ACTIVITY PRINCIPAL - OnPause");
        System.out.println(" --------------------------------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(" --------------------------------------");
        System.out.println("     ACTIVITY PRINCIPAL - OnStop");
        System.out.println(" --------------------------------------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(" --------------------------------------");
        System.out.println("     ACTIVITY PRINCIPAL - OnDestroy");
        System.out.println(" --------------------------------------");
    }
}
