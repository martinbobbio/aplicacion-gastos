package bobbio.martin.a00_agendagastos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RemoveTipoPago extends AppCompatActivity {

    ListView datos;
    ArrayList<Datos_tipo_pago_remove> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_tipo_pago);

        datos = (ListView) findViewById(R.id.lista_tipoPago_remove);
        lista = new ArrayList<>();

        BD helper = new BD(this, "Agenda", null, 9);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("select * from tipo_pagos", null);

        while (c.moveToNext()) {
            lista.add(new Datos_tipo_pago_remove(c.getString(c.getColumnIndex("tipoPago")),c.getInt(c.getColumnIndex("id")),R.drawable.icon_borrar));
        }

        Adaptador_tipo_pago_remove adaptador = new Adaptador_tipo_pago_remove(getApplicationContext(),lista);
        datos.setAdapter(adaptador);
        c.close();
    }

}
