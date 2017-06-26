package bobbio.martin.a00_agendagastos;

/**
 * Created by admin on 23/06/2017.
 */

public class Datos_tipo_pago_remove {

    private String tipoPago;
    private int id;
    private int imagen;

    public Datos_tipo_pago_remove(String tipoPago, int id, int imagen) {
        this.tipoPago = tipoPago;
        this.id = id;
        this.imagen = imagen;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
