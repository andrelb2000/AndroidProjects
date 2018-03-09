package br.com.amm.imagesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PrincipalImagens extends AppCompatActivity {

    Button bImg1;
    Button bImg2;
    Button bImg3;
    ImageView imgView1;
    Intent AllImgsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_imagens);

        this.bImg1 = (Button) findViewById(R.id.buttonIMG1);
        this.bImg2 = (Button) findViewById(R.id.buttonIMG2);
        this.bImg3 = (Button) findViewById(R.id.buttonIMG3);
        this.imgView1 = (ImageView) findViewById(R.id.imageViewIMG1);
        this.AllImgsIntent = new Intent(this,ImagensActivity.class);

        bImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView1.setImageResource(R.drawable.image1);
            }
        });

        bImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView1.setImageResource(R.drawable.image2);
            }
        });

        bImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView1.setImageResource(R.drawable.image3);


            }
        });

        imgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(AllImgsIntent);
            }
        });


    }
}
