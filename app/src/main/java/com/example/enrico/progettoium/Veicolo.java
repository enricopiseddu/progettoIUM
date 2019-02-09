package com.example.enrico.progettoium;

public class Veicolo {

    private String modello;
    private String targa;
    private int cilindrata;

    public Veicolo(String modello, String targa, int cilindrata){
        this.setModello(modello);
        this.setTarga(targa);
        this.setCilindrata(cilindrata);

    }


    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }
}
