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


public class Adaptador_gasto_remove extends BaseAdapter {

    Context contexto;
    List<Datos_gasto_remove> lista_gasto;


    public Adaptador_gasto_remove(Context contexto, List<Datos_gasto_remove> lista_categoria) {
        this.contexto = contexto;
        this.lista_gasto = lista_categoria;
    }

    @Override
    public int getCount() {
        return lista_gasto.size();
    }

    @Override
    public Object getItem(int position) {
        return lista_gasto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista_gasto.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflater = LayoutInflater.from(contexto);
        vista = inflater.inflate(R.layout.list_view_gasto_remove, null);

        TextView descripcion = (TextView)vista.findViewById(R.id.pago_descripcion_remove);
        TextView categoria = (TextView)vista.findViewById(R.id.pago_categoria_remove);
        TextView tipoPago = (TextView)vista.findViewById(R.id.pago_tipo_pago_remove);
        TextView monto = (TextView)vista.findViewById(R.id.pago_monto_remove);
        TextView fecha = (TextView)vista.findViewById(R.id.pago_fecha_remove);
        TextView id = (TextView)vista.findViewById(R.id.pago_id_remove);
        ImageButton imagen = (ImageButton)vista.findViewById(R.id.boton_eliminar);

        descripcion.append(": "+String.valueOf(lista_gasto.get(position).getDescripcion()));
        categoria.append(": "+String.valueOf(lista_gasto.get(position).getCategoria()));
        tipoPago.append(": "+String.valueOf(lista_gasto.get(position).getTipoPago()));
        monto.append(": "+String.valueOf(lista_gasto.get(position).getMonto()));
        fecha.append(": "+String.valueOf(lista_gasto.get(position).getFecha()));
        id.append(": "+String.valueOf(lista_gasto.get(position).getId()));
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BD helper = new BD(contexto, "Agenda", null, 9);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("gasto", "id="+ lista_gasto.get(position).getId(), null);

                Toast.makeText(contexto,String.valueOf(lista_gasto.get(position).getDescripcion())+" ha sido borrado!",
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(contexto, MainActivity.class);
                i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
                contexto.startActivity(i);

            }
        });

        return vista;

    }
}
