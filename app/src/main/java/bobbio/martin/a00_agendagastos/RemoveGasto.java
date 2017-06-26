package bobbio.martin.a00_agendagastos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RemoveGasto extends AppCompatActivity {

    ListView datos;
    ArrayList<Datos_gasto_remove> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_gasto);

        datos = (ListView) findViewById(R.id.lista_gasto_remove);
        lista = new ArrayList<>();

        BD helper = new BD(this, "Agenda", null, 9);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("select * from gasto", null);

        while (c.moveToNext()) {
            lista.add(new Datos_gasto_remove(c.getString(c.getColumnIndex("descripcion")),c.getString(c.getColumnIndex("categoria")),c.getString(c.getColumnIndex("tipoPago")),c.getDouble(c.getColumnIndex("monto")),c.getString(c.getColumnIndex("fecha")),c.getInt(c.getColumnIndex("id"))));
        }

        Adaptador_gasto_remove adaptador = new Adaptador_gasto_remove(getApplicationContext(),lista);
        datos.setAdapter(adaptador);
        c.close();
    }
}
