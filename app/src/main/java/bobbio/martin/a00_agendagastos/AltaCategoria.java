package bobbio.martin.a00_agendagastos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AltaCategoria extends AppCompatActivity {

    EditText campo_categoria;
    EditText campo_presupuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_categoria);

        campo_categoria = (EditText)findViewById(R.id.categoria);
        campo_presupuesto = (EditText)findViewById(R.id.presupuesto);
    }

    public void alta(View v){

        BD helper = new BD(this,"Agenda", null,9);
        SQLiteDatabase db = helper.getWritableDatabase();

        String categoria = campo_categoria.getText().toString();
        int presupuesto = Integer.parseInt(campo_presupuesto.getText().toString());

        if(db != null)
        {
            ContentValues registro = new ContentValues();
            registro.put("categoria", categoria);
            registro.put("presupuesto", presupuesto);

            db.insert("categorias", null, registro);
            db.close();

            Toast.makeText(this, categoria+" ha sido agregado con un presupuesto mensual de: "+presupuesto,
                    Toast.LENGTH_SHORT).show();

            Intent i = new Intent(AltaCategoria.this,MainActivity.class);
            startActivity(i);
            finish();

        }

    }

}