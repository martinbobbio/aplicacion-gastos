package bobbio.martin.a00_agendagastos;

        import android.content.ContentValues;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;


public class AltaGasto extends AppCompatActivity {

    Spinner spinner_categorias;
    Spinner spinner_tipoPago;
    EditText editText_monto;
    EditText editText_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_gasto);

        spinner_categorias = (Spinner)findViewById(R.id.spinner_categoria);
        spinner_tipoPago = (Spinner)findViewById(R.id.spinner_pago);
        editText_monto = (EditText) findViewById(R.id.gasto);
        editText_descripcion = (EditText) findViewById(R.id.descripcion);

        BD helper = new BD(this, "Agenda", null, 9);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c1 = db.rawQuery("select * from categorias", null);
        Cursor c2 = db.rawQuery("select * from tipo_pagos", null);
        ArrayList<String> categorias = new ArrayList<String>();
        ArrayList<String> tipoPagos = new ArrayList<String>();
        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,categorias);
        ArrayAdapter<String> adp2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,tipoPagos);

        while (c1.moveToNext()) {
            categorias.add(c1.getString(c1.getColumnIndex("categoria")));
        }
        while (c2.moveToNext()) {
            tipoPagos.add(c2.getString(c2.getColumnIndex("tipoPago")));
        }

        spinner_categorias.setAdapter(adp1);
        spinner_tipoPago.setAdapter(adp2);

        c1.close();
        c2.close();


    }

    public void alta(View v){

        BD helper = new BD(this,"Agenda", null,9);
        SQLiteDatabase db = helper.getWritableDatabase();

        String categoria = spinner_categorias.getSelectedItem().toString();
        String tipoPago = spinner_tipoPago.getSelectedItem().toString();
        String descripcion = editText_descripcion.getText().toString();
        String monto = editText_monto.getText().toString();
        String fecha = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());

        if(db != null) {

            ContentValues registro = new ContentValues();
            registro.put("categoria", categoria);
            registro.put("tipoPago", tipoPago);
            registro.put("descripcion", descripcion);
            registro.put("monto", monto);
            registro.put("fecha", fecha);

            db.insert("gasto", null, registro);
            db.close();

            Toast.makeText(this, "Categoria: "+categoria+"Tipo de pago: "+tipoPago+"descripcion: "+descripcion+"Monto: "+monto+"Fecha: "+fecha,
                    Toast.LENGTH_LONG).show();

            Intent i = new Intent(AltaGasto.this, MainActivity.class);
            startActivity(i);
            finish();

        }

    }
}
