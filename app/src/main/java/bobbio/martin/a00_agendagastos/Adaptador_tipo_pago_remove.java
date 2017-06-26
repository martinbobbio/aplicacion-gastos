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


public class Adaptador_tipo_pago_remove extends BaseAdapter {

    Context contexto;
    List<Datos_tipo_pago_remove> lista_tipoPago;


    public Adaptador_tipo_pago_remove(Context contexto, List<Datos_tipo_pago_remove> listaGastos) {
        this.contexto = contexto;
        this.lista_tipoPago = listaGastos;
    }

    @Override
    public int getCount() {
        return lista_tipoPago.size();
    }

    @Override
    public Object getItem(int position) {
        return lista_tipoPago.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista_tipoPago.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflater = LayoutInflater.from(contexto);
        vista = inflater.inflate(R.layout.list_view_tipo_pago_remove, null);

        TextView tipoPago = (TextView)vista.findViewById(R.id.tipo_pago_tipoPago);
        TextView id = (TextView)vista.findViewById(R.id.tipo_pago_id);
        ImageButton imagen = (ImageButton)vista.findViewById(R.id.boton_eliminar);

        tipoPago.append(": "+String.valueOf(lista_tipoPago.get(position).getTipoPago()));
        id.append(": "+String.valueOf(lista_tipoPago.get(position).getId()));
        imagen.setImageResource(lista_tipoPago.get(position).getImagen());
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BD helper = new BD(contexto, "Agenda", null, 9);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("tipo_pagos", "id="+lista_tipoPago.get(position).getId(), null);

                Toast.makeText(contexto,String.valueOf(lista_tipoPago.get(position).getTipoPago())+" ha sido borrado!",
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(contexto, MainActivity.class);
                i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
                contexto.startActivity(i);

            }
        });

        return vista;

    }
}
