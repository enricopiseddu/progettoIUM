package com.example.enrico.progettoium;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import java.io.Serializable;

public class VisualizzaPolizza extends AppCompatActivity {

    Polizza polizza;

    TextView infoVeicolo, statoPolizza, accessori;
    String listaAccessori;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_polizza);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(LeMiePolizze.POLIZZA_EXTRA);

        polizza=(Polizza)obj;

        infoVeicolo=(TextView)findViewById(R.id.infoVeicolo);
        statoPolizza=(TextView)findViewById(R.id.statoPolizza);
        accessori=(TextView)findViewById(R.id.accessori);

        infoVeicolo.setText("Veicolo:                " + polizza.getVeicolo().getModello() + "\n" +
                            "Targa:                    " + polizza.getVeicolo().getTarga() + "\n\n" +
                            "N° Polizza:            " + polizza.getNumeroPolizza() + "\n"+
                            "Classe di Merito: " + polizza.getClasseMerito() + "\n" +
                            "Data Scadenza:   " + polizza.getMeseScadenza()+ "/" +
                                                polizza.getAnnoScadenza() + "\n\n" +
                            "Premio:                 € " + polizza.getPrezzo() +"0"
        );


        listaAccessori=polizza.getAccessori().toString();
        accessori.setText(listaAccessori);

        if(polizza.getAnnoScadenza()<2019){
            statoPolizza.setText("POLIZZA SCADUTA");
            statoPolizza.setTextColor(Color.RED);
        }
        else if(polizza.getAnnoScadenza()==2019){
                if(polizza.getMeseScadenza()>=2){
                    statoPolizza.setText("POLIZZA ATTIVA");
                    statoPolizza.setTextColor(Color.GREEN);
                }
                else{
                    statoPolizza.setText("POLIZZA SCADUTA");
                    statoPolizza.setTextColor(Color.RED);
                }
             }
             else{
                statoPolizza.setText("POLIZZA ATTIVA");
                statoPolizza.setTextColor(Color.GREEN);
             }


             if(polizza.getMeseScadenza()==2 && polizza.getAnnoScadenza()==2019){
                statoPolizza.setText("POLIZZA IN SCADENZA");
                //colore arancione
                statoPolizza.setTextColor(Color.rgb(255,215,0));
             }



    }

}
