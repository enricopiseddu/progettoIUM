package com.example.enrico.progettoium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MostraPreventivo extends AppCompatActivity {

    TextView datiVeicolo, prezzo;
    Polizza polizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_preventivo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_stat_name);
        toolbar.setTitle("Dettaglio preventivo");// your drawable
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });

        datiVeicolo = findViewById(R.id.datiVeicoloMostraPreventivo);
        prezzo = findViewById(R.id.prezzoPreventivo);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(Preventivi.POLIZZA_EXTRA);

        polizza = (Polizza)obj;

        datiVeicolo.setText("Targa: " +polizza.getVeicolo().getTarga()+
                "\nModello: " + polizza.getVeicolo().getModello() +
                "\nAccessori: "+polizza.getAccessori().toString());

        prezzo.setText("Premio calcolato: € " + Float.toString(polizza.getPrezzo()) +"0");

    }
}
