package bobbio.martin.a00_agendagastos;


public class Datos_gasto_remove {

    private String descripcion;
    private String categoria;
    private String tipoPago;
    private double monto;
    private String fecha;
    private int id;

    public Datos_gasto_remove(String descripcion, String categoria, String tipoPago, double monto, String fecha, int id) {
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipoPago = tipoPago;
        this.monto = monto;
        this.fecha = fecha;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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
