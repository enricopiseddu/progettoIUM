package com.example.enrico.progettoium;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class LeMiePolizze extends AppCompatActivity {

    Veicolo v1 = new Veicolo("Toyota Yaris", "EK729FG", 1400);
    Veicolo v2 = new Veicolo("Fiat Punto", "BN7980AA", 1300);

    Polizza p1 = new Polizza(v1);
    Polizza p2 = new Polizza(v2);
    ArrayList<Polizza> polizze = new ArrayList<>(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_mie_polizze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        polizze.add(p1);
        polizze.add(p2);




    }
}
