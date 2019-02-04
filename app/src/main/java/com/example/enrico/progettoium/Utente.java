package com.example.enrico.progettoium;

import java.io.Serializable;
import java.util.Date;

public class Utente implements Serializable {

    private String nome;
    private String cognome;
    private String password;
    private String dataNascita;
    private String email;
    private long nrCartaCredito;
    private long nrTelefono;
    private String Indirizzo;


    //costruttore
    public Utente(String nome, String cognome, String email, String password,
                  String dataNascita, long nrCartaCredito, long nrTelefono){

        this.setNome(nome);
        this.setCognome(cognome);
        this.setPassword(password);
        this.setDataNascita(dataNascita);
        this.setEmail(email);
        this.setNrCartaCredito(nrCartaCredito);
        this.setNrTelefono(nrTelefono);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNrCartaCredito() {
        return nrCartaCredito;
    }

    public void setNrCartaCredito(long nrCartaCredito) {
        this.nrCartaCredito = nrCartaCredito;
    }

    public long getNrTelefono() {
        return nrTelefono;
    }

    public void setNrTelefono(long nrTelefono) {
        this.nrTelefono = nrTelefono;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        Indirizzo = indirizzo;
    }
}
