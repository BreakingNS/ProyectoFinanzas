package model;

import java.util.Date;

public class Ingreso {
    private int id;
    private Integer monto;
    private String descripcion;
    private Date fecha;
    private Categoria categoria;

    public Ingreso() {
    }

    public Ingreso(int id, Integer monto, String descripcion, Date fecha, Categoria categoria) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.categoria = categoria;
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

    public Date getFecha() {
        return fecha;
    }

    public Categoria getCategoria() {
        return categoria;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
}
