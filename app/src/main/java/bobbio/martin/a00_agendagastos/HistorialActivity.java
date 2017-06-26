package bobbio.martin.a00_agendagastos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class HistorialActivity extends AppCompatActivity {

    ListView datos;
    ArrayList<Datos_gastos> lista;
    Spinner meses;
    String filtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        datos = (ListView) findViewById(R.id.lista_gastos);
        lista = new ArrayList<>();

        meses = (Spinner)findViewById(R.id.spinner_meses1);
        ArrayList<String> lista_meses = new ArrayList<String>();
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,lista_meses);
        lista_meses.add("Ninguno");lista_meses.add("Todos");
        lista_meses.add("Enero");lista_meses.add("Febrero");lista_meses.add("Marzo");lista_meses.add("Abril");
        lista_meses.add("Mayo");lista_meses.add("Junio");lista_meses.add("Julio");lista_meses.add("Agosto");
        lista_meses.add("Septiembre");lista_meses.add("Octubre");lista_meses.add("Noviembre");lista_meses.add("Diciembre");
        meses.setAdapter(adp);
        meses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String mes = meses.getSelectedItem().toString();
                Intent intent = new Intent(getApplicationContext(), HistorialActivity.class);
                switch (i){
                    case 1:
                        mes = "%%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        mes = "%.01.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        mes = "%.02.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 4:
                        mes = "%.03.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 5:
                        mes = "%.04.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 6:
                        mes = "%.05.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 7:
                        mes = "%.06.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 8:
                        mes = "%.07.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 9:
                        mes = "%.08.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 10:
                        mes = "%.09.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 11:
                        mes = "%.10.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 12:
                        mes = "%.11.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                    case 13:
                        mes = "%.12.%";
                        intent.putExtra("mes", mes);
                        startActivity(intent);
                        finish();
                        break;
                }


            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Intent intent = getIntent();
        filtro = intent.getStringExtra("mes");

        BD helper = new BD(this, "Agenda", null, 9);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("select * from gasto where fecha like '"+filtro+"'", null);

        while (c.moveToNext()) {
            if(c.getString(0).isEmpty()){
                Toast.makeText(this,"El historial esta vacio!",
                        Toast.LENGTH_SHORT).show();
            }else{
                lista.add(new Datos_gastos(c.getString(c.getColumnIndex("categoria")), c.getDouble(c.getColumnIndex("monto")), c.getString(c.getColumnIndex("tipoPago")), c.getString(c.getColumnIndex("descripcion")), c.getString(c.getColumnIndex("fecha"))));

            }
        }

        Adaptador_gastos adaptador = new Adaptador_gastos(getApplicationContext(),lista);
        datos.setAdapter(adaptador);
        c.close();
    }
}
