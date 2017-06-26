package bobbio.martin.a00_agendagastos;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Adaptador_categoria_remove extends BaseAdapter {

    Context contexto;
    List<Datos_categoria_remove> lista_categoria;


    public Adaptador_categoria_remove(Context contexto, List<Datos_categoria_remove> lista_categoria) {
        this.contexto = contexto;
        this.lista_categoria = lista_categoria;
    }

    @Override
    public int getCount() {
        return lista_categoria.size();
    }

    @Override
    public Object getItem(int position) {
        return lista_categoria.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista_categoria.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflater = LayoutInflater.from(contexto);
        vista = inflater.inflate(R.layout.list_view_categoria_remove, null);

        TextView categoria = (TextView)vista.findViewById(R.id.categoria_categoria_remove);
        TextView presupuesto = (TextView)vista.findViewById(R.id.categoria_presupuesto_remove);
        TextView id = (TextView)vista.findViewById(R.id.categoria_id_remove);
        ImageButton imagen = (ImageButton)vista.findViewById(R.id.boton_eliminar);

        categoria.append(": "+String.valueOf(lista_categoria.get(position).getCategoria()));
        presupuesto.append(": "+String.valueOf(lista_categoria.get(position).getPresupuesto()));
        id.append(": "+String.valueOf(lista_categoria.get(position).getId()));
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BD helper = new BD(contexto, "Agenda", null, 9);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("categorias", "id="+ lista_categoria.get(position).getId(), null);

                Toast.makeText(contexto,String.valueOf(lista_categoria.get(position).getCategoria())+" ha sido borrado!",
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(contexto, MainActivity.class);
                i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
                contexto.startActivity(i);

            }
        });

        return vista;

    }
}
