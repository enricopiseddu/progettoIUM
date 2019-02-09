package com.example.enrico.progettoium;

import java.util.ArrayList;
import java.util.Date;

public class Polizza {

    private Veicolo veicolo;
    private float prezzo=160.00f;
    private ArrayList<String> accessori;
    private String data_scadenza;

    private boolean assistenza_stradale=false;
    private boolean kasko=false;
    private boolean furto=false;
    private boolean incendio=false;
    private boolean guida_esperta=false;
    private boolean cristalli=false;

    public Polizza(Veicolo veicolo){
        this.veicolo=veicolo;
        this.prezzo=prezzo*veicolo.getCilindrata()/100;
        this.data_scadenza="31-12-2019";
    }


    public boolean isAssistenza_stradale() {
        return assistenza_stradale;
    }

    public void setAssistenza_stradale(boolean assistenza_stradale) {
        this.assistenza_stradale = assistenza_stradale;
    }

    public boolean isKasko() {
        return kasko;
    }

    public void setKasko(boolean kasko) {
        this.kasko = kasko;
    }

    public boolean isFurto() {
        return furto;
    }

    public void setFurto(boolean furto) {
        this.furto = furto;
    }

    public boolean isIncendio() {
        return incendio;
    }

    public void setIncendio(boolean incendio) {
        this.incendio = incendio;
    }

    public boolean isGuida_esperta() {
        return guida_esperta;
    }

    public void setGuida_esperta(boolean guida_esperta) {
        this.guida_esperta = guida_esperta;
    }

    public boolean isCristalli() {
        return cristalli;
    }

    public void setCristalli(boolean cristalli) {
        this.cristalli = cristalli;
    }

    public void aggiornaAccessori(){
        if(isAssistenza_stradale())
            accessori.add("Assistenza Stradale");
        else
            accessori.remove("Assistenza Stradale");

        if(isCristalli())
            accessori.add("Cristalli");
        else
            accessori.remove("Cristalli");

        if(isFurto())
            accessori.add("Furto");
        else
            accessori.remove("Furto");

        if(isGuida_esperta())
            accessori.add("Guida Esperta");
        else
            accessori.remove("Guida Esperta");

        if (isIncendio())
            accessori.add("Incendio");
        else
            accessori.remove("Incendio");

        if(isKasko())
            accessori.add("Kasko");
        else
            accessori.remove("Kasko");
    }

    public String getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(String data_scadenza) {
        this.data_scadenza = data_scadenza;
    }
}