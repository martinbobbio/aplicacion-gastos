package bobbio.martin.a00_agendagastos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AltaTipoPago extends AppCompatActivity {

    EditText campo_tipoPago;
    double latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_tipo_pago);

        campo_tipoPago = (EditText) findViewById(R.id.tipoPago);
    }

    public void alta(View v) {

        BD helper = new BD(this, "Agenda", null, 9);
        SQLiteDatabase db = helper.getWritableDatabase();

        String tipoPago = campo_tipoPago.getText().toString();

        if (db != null) {

            ContentValues registro = new ContentValues();
            registro.put("tipoPago", tipoPago);

            db.insert("tipo_pagos", null, registro);
            db.close();

            Toast.makeText(this, tipoPago + " ha sido agregado!",
                    Toast.LENGTH_SHORT).show();

            Intent i = new Intent(AltaTipoPago.this, MainActivity.class);
            startActivity(i);
            finish();

        }
    }
}
