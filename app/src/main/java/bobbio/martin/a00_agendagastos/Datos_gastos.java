package bobbio.martin.a00_agendagastos;

/**
 * Created by admin on 23/06/2017.
 */

public class Datos_gastos {

    private String categoria;
    private double gasto;
    private String tipoPago;
    private String descripcion;
    private String fecha;
    private int id;

    public Datos_gastos(String categoria, double gasto, String tipoPago, String descripcion, String fecha) {
        this.categoria = categoria;
        this.gasto = gasto;
        this.tipoPago = tipoPago;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
