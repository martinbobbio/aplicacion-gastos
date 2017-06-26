package bobbio.martin.a00_agendagastos;


public class Datos_categoria_remove {

    private String categoria;
    private int presupuesto;
    private int id;

    public Datos_categoria_remove(String categoria, int presupuesto, int id) {
        this.categoria = categoria;
        this.presupuesto = presupuesto;
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
