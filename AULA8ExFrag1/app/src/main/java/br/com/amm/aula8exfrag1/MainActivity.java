package br.com.amm.aula8exfrag1;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment bf = getSupportFragmentManager().findFragmentById(R.id.fragment);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
