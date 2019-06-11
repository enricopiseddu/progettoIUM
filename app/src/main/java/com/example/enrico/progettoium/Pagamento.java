package com.example.enrico.progettoium;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.Serializable;

public class Pagamento extends AppCompatActivity {

    Polizza polizza;
    TextView modelloVeicolo, targaVeicolo, listaAccessori, prezzoDaPagare, datiInformativi;
    EditText numeroCarta, meseScadenza, annoScadenza, codiceCCV;

    String numero_carta, mese_scadenza, anno_scadenza, codice_ccv;

    Button pagaOra;
    String lista_acc;
    public static final String POLIZZA_EXTRA="com.example.enrico.progettoium.Polizza";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(LeMiePolizze.POLIZZA_EXTRA);

        polizza=(Polizza)obj;



        modelloVeicolo = (TextView)findViewById(R.id.modelloVeicolo);
        targaVeicolo = (TextView)findViewById(R.id.targaVeicolo);
        listaAccessori = (TextView)findViewById(R.id.listaAccessori);
        prezzoDaPagare = (TextView)findViewById(R.id.prezzoDaPagare);
        numeroCarta = (EditText)findViewById(R.id.nr_carta);
        meseScadenza = (EditText)findViewById(R.id.meseScadenzaCarta);
        annoScadenza = (EditText)findViewById(R.id.annoScadenzaCarta);
        codiceCCV = (EditText)findViewById(R.id.codiceCCV);
        pagaOra = (Button)findViewById(R.id.paga);
        datiInformativi = (TextView)findViewById(R.id.datiInformativi);


        modelloVeicolo.setText(polizza.getVeicolo().getModello());
        targaVeicolo.setText(polizza.getVeicolo().getTarga());
        listaAccessori.setText(polizza.getAccessori().toString());
        prezzoDaPagare.setText(String.valueOf(polizza.getPrezzo()) + "0");


        lista_acc =polizza.getAccessori().toString();
        listaAccessori.setText(Html.fromHtml("<u>"+lista_acc+"</u>"));


        pagaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numero_carta = numeroCarta.getText().toString();
                mese_scadenza = meseScadenza.getText().toString();
                anno_scadenza = annoScadenza.getText().toString();
                codice_ccv = codiceCCV.getText().toString();

                if (checkInput()){
                    Snackbar.make(v, "Il pagamento è avvenuto con successo!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    pagaOra.setVisibility(View.GONE);
                    datiInformativi.setText("Il pagamento è stato effettuato e la polizza è stata correttamente " +
                            "attivata. Riceverai una mail di conferma con allegata la ricevuta");
                    datiInformativi.setTextColor(Color.rgb(0,204,0));
                }

            }
        });

        listaAccessori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Pagamento.this,
                        ModificaPolizza.class);
                menu.putExtra(POLIZZA_EXTRA, polizza);
                startActivity(menu);
            }
        });




    }

    private boolean checkInput(){

        int errors=0;

        if (numero_carta == null || numero_carta.length()!=16) {
            errors++;
            numeroCarta.setError("Inserisci un numero di carta valido");
        }
        else
            numeroCarta.setError(null);

        if (/*meseScadenza.getText() == null || */Integer.valueOf(mese_scadenza)>12 || Integer.valueOf(mese_scadenza)<1) {
            errors++;
            meseScadenza.setError("Inserisci un mese valido");
        }
        else
            meseScadenza.setError(null);

        if (/*annoScadenza.getText() == null || */Integer.valueOf(anno_scadenza)>2050 || Integer.valueOf(anno_scadenza)<2019) {
            errors++;
            annoScadenza.setError("Inserisci un anno valido");
        }
        else
            annoScadenza.setError(null);

        if (codice_ccv == null || codice_ccv.length()!=3) {
            errors++;
            codiceCCV.setError("Inserisci un codice CCV valido");
        }
        else
            codiceCCV.setError(null);

        return errors==0; // ritorna true se non ci sono errori

    }
}
