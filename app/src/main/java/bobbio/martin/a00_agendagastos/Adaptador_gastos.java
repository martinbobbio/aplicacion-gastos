package bobbio.martin.a00_agendagastos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class Adaptador_gastos extends BaseAdapter {

    Context contexto;
    List<Datos_gastos> listaGastos;


    public Adaptador_gastos(Context contexto, List<Datos_gastos> listaGastos) {
        this.contexto = contexto;
        this.listaGastos = listaGastos;
    }

    @Override
    public int getCount() {
        return listaGastos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaGastos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaGastos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflater = LayoutInflater.from(contexto);
        vista = inflater.inflate(R.layout.list_view_gastos, null);

        TextView gasto = (TextView)vista.findViewById(R.id.gasto_monto);
        TextView categoria = (TextView)vista.findViewById(R.id.gasto_categoria);
        TextView tipoPago = (TextView)vista.findViewById(R.id.gasto_tipoPago);
        TextView descripcion = (TextView)vista.findViewById(R.id.gasto_descripcion);
        TextView fecha = (TextView)vista.findViewById(R.id.gasto_fecha);

        gasto.append(": "+String.valueOf(listaGastos.get(position).getGasto())+"0");
        categoria.append(": "+String.valueOf(listaGastos.get(position).getCategoria()));
        tipoPago.append(": "+String.valueOf(listaGastos.get(position).getTipoPago()));
        descripcion.append(": "+String.valueOf(listaGastos.get(position).getDescripcion()));
        fecha.append(": "+String.valueOf(listaGastos.get(position).getFecha()));

        return vista;

    }
}
