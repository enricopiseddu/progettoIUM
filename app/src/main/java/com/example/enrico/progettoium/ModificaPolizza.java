package com.example.enrico.progettoium;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ModificaPolizza extends AppCompatActivity {

    Polizza polizza;
    TextView datiVeicolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_polizza);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(LeMiePolizze.POLIZZA_EXTRA);

        polizza=(Polizza)obj;

        datiVeicolo=(TextView)findViewById(R.id.datiVeicolo);

        datiVeicolo.setText("Polizza nr°: "+ polizza.getNumeroPolizza() +
                            "\nVeicolo:       " + polizza.getVeicolo().getModello() +
                            "\nTarga:          " + polizza.getVeicolo().getTarga());

    }

}
