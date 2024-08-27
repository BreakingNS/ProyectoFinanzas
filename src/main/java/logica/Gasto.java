package logica;

import java.util.Date;

public class Gasto {
    private int id;
    private Integer monto;
    private String descripcion;
    private String categoria;
    private Date fecha;

    public Gasto() {
    }

    public Gasto(int id, Integer monto, String descripcion, String categoria, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public Integer getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
