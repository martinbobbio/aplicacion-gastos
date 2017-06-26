package bobbio.martin.a00_agendagastos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView gastoMensual,presupuestoMensual, etiquetaFiltro;
    Spinner meses;
    ListView datos;
    ArrayList<Datos_categoria> lista;
    String filtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.app_name);
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        gastoMensual = (TextView)findViewById(R.id.gasto_mensual2);
        presupuestoMensual = (TextView)findViewById(R.id.presupuesto_mensual2);
        etiquetaFiltro = (TextView)findViewById(R.id.filtro);
        datos = (ListView) findViewById(R.id.lista_categoria);
        lista = new ArrayList<>();

        SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        presupuestoMensual.append(prefs.getString("presupuesto"," 10000.00"));

        meses = (Spinner)findViewById(R.id.spinner_meses);
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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                switch (i){
                    case 1:
                        mes = "%%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Todos");
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        mes = "%.01.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Enero");
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        mes = "%.02.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Febrero");
                        startActivity(intent);
                        finish();
                        break;
                    case 4:
                        mes = "%.03.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Marzo");
                        startActivity(intent);
                        finish();
                        break;
                    case 5:
                        mes = "%.04.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Abril");
                        startActivity(intent);
                        finish();
                        break;
                    case 6:
                        mes = "%.05.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Todos");
                        intent.putExtra("filtro", "Mayo");
                        startActivity(intent);
                        finish();
                        break;
                    case 7:
                        mes = "%.06.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Junio");
                        startActivity(intent);
                        finish();
                        break;
                    case 8:
                        mes = "%.07.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Julio");
                        startActivity(intent);
                        finish();
                        break;
                    case 9:
                        mes = "%.08.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Agosto");
                        startActivity(intent);
                        finish();
                        break;
                    case 10:
                        mes = "%.09.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Septiembre");
                        startActivity(intent);
                        finish();
                        break;
                    case 11:
                        mes = "%.10.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Octubre");
                        startActivity(intent);
                        finish();
                        break;
                    case 12:
                        mes = "%.11.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Noviembre");
                        startActivity(intent);
                        finish();
                        break;
                    case 13:
                        mes = "%.12.%";
                        intent.putExtra("mes", mes);
                        intent.putExtra("filtro", "Diciembre");
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
        etiquetaFiltro.setText(intent.getStringExtra("filtro"));

        BD helper = new BD(this, "Agenda", null, 9);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c1 = db.rawQuery("select sum(monto) from gasto where fecha like '"+filtro+"'", null);
        Cursor c2 = db.rawQuery("select * from categorias", null);

        if (c1.moveToFirst()) {
            if(c1.getString(0) == null){
                gastoMensual.append(" 0.00");
            }else{
                gastoMensual.append(c1.getString(0)+".00");
            }
        }

        while(c2.moveToNext()){
            lista.add(new Datos_categoria(c2.getString(c2.getColumnIndex("categoria")),c2.getInt(c2.getColumnIndex("presupuesto")),c2.getInt(c2.getColumnIndex("id"))));
        }
        Adaptador_categoria adaptador = new Adaptador_categoria(getApplicationContext(),lista);
        datos.setAdapter(adaptador);

        c1.close();
        c2.close();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_category) {
            Intent i = new Intent(this,AltaCategoria.class);
            startActivity(i);
        }
        if(id == R.id.remove_category){
            Intent i = new Intent(this,RemoveCategoria.class);
            startActivity(i);
        }
        if(id == R.id.add_payment){
            Intent i = new Intent(this,AltaTipoPago.class);
            startActivity(i);
        }
        if(id == R.id.remove_payment){
            Intent i = new Intent(this,RemoveTipoPago.class);
            startActivity(i);
        }
        if(id == R.id.add){
            Intent i = new Intent(this,AltaGasto.class);
            startActivity(i);
        }
        if(id == R.id.remove){
            Intent i = new Intent(this,RemoveGasto.class);
            startActivity(i);
        }
        if(id == R.id.history){
            Intent i = new Intent(this,HistorialActivity.class);
            startActivity(i);
        }
        if(id == R.id.settings){
            Intent i = new Intent(this,Preferencias.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}



