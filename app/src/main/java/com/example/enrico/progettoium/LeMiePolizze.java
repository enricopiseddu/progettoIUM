package com.example.enrico.progettoium;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class LeMiePolizze extends AppCompatActivity {

    Veicolo v1 = new Veicolo("Toyota Yaris", "EK729FG", 1400);
    Veicolo v2 = new Veicolo("Fiat Punto", "BN7980AA", 1300);
    Veicolo v3 = new Veicolo("Lancia Ypsilon", "DE154LR", 1200 );
    Polizza p1 = new Polizza(v1);
    Polizza p2 = new Polizza(v2);
    Polizza p3 = new Polizza(v3);



    TextView modello_v1, modello_v2, modello_v3;
    Button vedi1, vedi2, vedi3, modifica1, modifica2, modifica3;

    public static final String POLIZZA_EXTRA="com.example.enrico.progettoium.Polizza";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_mie_polizze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        p1.setAnnoScadenza(2019);
        p1.setMeseScadenza(5);

        p2.setAnnoScadenza(2018);
        p2.setMeseScadenza(12);

        p3.setAnnoScadenza(2019);
        p3.setMeseScadenza(2);

        p1.setKasko(true);
        p1.setGuida_esperta(true);
        p1.aggiornaAccessori();

        p2.setIncendio(true);
        p2.setCristalli(true);
        p2.aggiornaAccessori();

        p3.setFurto(true);
        p3.setAssistenza_stradale(true);
        p3.aggiornaAccessori();

        modello_v1 = (TextView)findViewById(R.id.modello_v1);
        modello_v2 = (TextView)findViewById(R.id.modello_v2);
        modello_v3 = (TextView)findViewById(R.id.modello_v3);


        modello_v1.setText(p1.getVeicolo().getModello());
        modello_v1.setVisibility(View.VISIBLE);

        modello_v2.setText(p2.getVeicolo().getModello());
        modello_v2.setVisibility(View.VISIBLE);

        modello_v3.setText(p3.getVeicolo().getModello());
        modello_v3.setVisibility(View.VISIBLE);


        vedi1=(Button)findViewById(R.id.vedi1);
        vedi2=(Button)findViewById(R.id.vedi2);
        vedi3=(Button)findViewById(R.id.vedi3);

        modifica1=(Button)findViewById(R.id.modifica1);
        modifica2=(Button)findViewById(R.id.modifica2);
        modifica3=(Button)findViewById(R.id.modifica3);


        vedi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visualizza_polizza = new Intent(LeMiePolizze.this,
                        VisualizzaPolizza.class);
                visualizza_polizza.putExtra(POLIZZA_EXTRA, p1);
                startActivity(visualizza_polizza);
            }
        });

        vedi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visualizza_polizza = new Intent(LeMiePolizze.this,
                        VisualizzaPolizza.class);

                visualizza_polizza.putExtra(POLIZZA_EXTRA, p2);
                startActivity(visualizza_polizza);
            }
        });

        vedi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visualizza_polizza = new Intent(LeMiePolizze.this,
                        VisualizzaPolizza.class);
                visualizza_polizza.putExtra(POLIZZA_EXTRA, p3);
                startActivity(visualizza_polizza);
            }
        });





    }
}
