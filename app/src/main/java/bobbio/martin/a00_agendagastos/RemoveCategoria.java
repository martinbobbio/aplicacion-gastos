package bobbio.martin.a00_agendagastos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RemoveCategoria extends AppCompatActivity {

    ListView datos;
    ArrayList<Datos_categoria_remove> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_categoria);

        datos = (ListView) findViewById(R.id.lista_categoria_remove);
        lista = new ArrayList<>();

        BD helper = new BD(this, "Agenda", null, 9);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("select * from categorias", null);

        while (c.moveToNext()) {
            lista.add(new Datos_categoria_remove(c.getString(c.getColumnIndex("categoria")),c.getInt(c.getColumnIndex("presupuesto")),c.getInt(c.getColumnIndex("id"))));
        }

        Adaptador_categoria_remove adaptador = new Adaptador_categoria_remove(getApplicationContext(),lista);
        datos.setAdapter(adaptador);
        c.close();
    }
}
