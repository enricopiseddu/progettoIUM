package com.example.enrico.progettoium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Pagamento extends AppCompatActivity {

    Polizza polizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(LeMiePolizze.POLIZZA_EXTRA);

        polizza=(Polizza)obj;





    }
}
