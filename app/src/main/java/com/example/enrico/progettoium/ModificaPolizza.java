package com.example.enrico.progettoium;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ModificaPolizza extends AppCompatActivity {

    Polizza polizza;
    TextView datiVeicolo, totaleAccessori, msg_aggiornamento_accessori;
    Switch assistenzaStradale, cristalli, furto, guidaEsperta, incendio ,kasko;
    Button pulsanteAggiornaAccessori;

    int prezzoAccessori=0;


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


        totaleAccessori=(TextView)findViewById(R.id.totaleAccessori);

        pulsanteAggiornaAccessori=(Button)findViewById(R.id.pulsanteAggiornaAccessori);
        msg_aggiornamento_accessori=(TextView)findViewById(R.id.msg_aggiornamento_accessori);

        assistenzaStradale=(Switch)findViewById(R.id.assistenzaStradale);
        cristalli=(Switch)findViewById(R.id.cristalli);
        furto=(Switch)findViewById(R.id.furto);
        guidaEsperta=(Switch)findViewById(R.id.guidaEsperta);
        incendio=(Switch)findViewById(R.id.incendio);
        kasko=(Switch)findViewById(R.id.kasko);

        totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");


        assistenzaStradale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(assistenzaStradale.isChecked()){
                    prezzoAccessori+=50;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
                else {
                    prezzoAccessori -= 50;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
            }
        });

        cristalli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cristalli.isChecked()){
                    prezzoAccessori+=110;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
                else {
                    prezzoAccessori -= 110;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
            }
        });

        furto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(furto.isChecked()){
                    prezzoAccessori+=470;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
                else {
                    prezzoAccessori -= 470;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
            }
        });

        guidaEsperta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guidaEsperta.isChecked()){
                    prezzoAccessori-=90;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
                else {
                    prezzoAccessori += 90;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
            }
        });

        incendio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(incendio.isChecked()){
                    prezzoAccessori+=380;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
                else {
                    prezzoAccessori -= 380;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
            }
        });

        kasko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kasko.isChecked()){
                    prezzoAccessori+=740;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
                else {
                    prezzoAccessori -= 740;
                    totaleAccessori.setText("Totale Accessori € "+Integer.toString(prezzoAccessori)+".00");
                }
            }
        });


        pulsanteAggiornaAccessori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg_aggiornamento_accessori.setVisibility(View.VISIBLE);
            }
        });



    }
}

