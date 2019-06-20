package com.example.enrico.progettoium;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NuovoPreventivo extends AppCompatActivity {

    public static final String[] frazionamento = new String[]{"Annuale","Semestrale"};

    EditText targa, decorrenza;
    Spinner spinnerFrazionamento;
    DataPickerFragment datePickerFragment = new DataPickerFragment();
    CheckBox condizioniPreventivo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_preventivo);

        spinnerFrazionamento = (Spinner)findViewById(R.id.spinner);
        targa = (EditText)findViewById(R.id.targaPreventivo);
        decorrenza = (EditText)findViewById(R.id.decorrenza);
        condizioniPreventivo = (CheckBox)findViewById(R.id.condizioniPreventivo);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, frazionamento);
        spinnerFrazionamento.setAdapter(adapter);


        decorrenza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        datePickerFragment.setOnDatePickerFragmentChanged(new DataPickerFragment.DataPickerFragmentListener() {
            @Override
            public void onDatePickerFragmentOkButton(DialogFragment dialog, Calendar date) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                decorrenza.setText(format.format(date.getTime()));
            }

            @Override
            public void onDatePickerFragmentCancelButton(DialogFragment dialog) {

            }
        });
    }
}