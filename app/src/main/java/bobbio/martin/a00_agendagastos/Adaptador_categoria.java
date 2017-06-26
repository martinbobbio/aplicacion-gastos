package bobbio.martin.a00_agendagastos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class Adaptador_categoria extends BaseAdapter {

    Context contexto;
    List<Datos_categoria> lista_categoria;

    public Adaptador_categoria(Context contexto, List<Datos_categoria> lista_categoria) {
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
        vista = inflater.inflate(R.layout.list_view_categoria, null);

        TextView categoria = (TextView)vista.findViewById(R.id.categoria_categoria_remove);
        TextView presupuesto = (TextView)vista.findViewById(R.id.categoria_presupuesto_remove);
        TextView monto = (TextView)vista.findViewById(R.id.categoria_monto);

        categoria.append(" "+String.valueOf(lista_categoria.get(position).getCategoria()));
        presupuesto.append(": "+String.valueOf(lista_categoria.get(position).getPresupuesto()+".00"));

        BD helper = new BD(contexto, "Agenda", null, 9);
        SQLiteDatabase db = helper.getReadableDatabase();



        Cursor c = db.rawQuery("select sum(monto) from gasto where categoria = '"+String.valueOf(lista_categoria.get(position).getCategoria())+"'", null);

        if(c != null){
            c.moveToFirst();
            monto.append(": "+String.valueOf(c.getDouble(0))+"0");
        }else{
            monto.append(": 0.0");
        }

        c.close();

        return vista;

    }
}
