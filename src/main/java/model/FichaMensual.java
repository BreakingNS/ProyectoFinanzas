package model;

public class FichaMensual {
    private int id;
    private int mes;
    private int anio;
    private Integer ingresosTotales;
    private Integer gastosTotales;
    private Integer saldoFinal;
    private int usuarioId;

    public FichaMensual() {
    }
    
    public FichaMensual(int id, int mes, int anio, Integer ingresosTotales, Integer gastosTotales, Integer saldoFinal, int usuarioId) {
        this.id = id;
        this.mes = mes;
        this.anio = anio;
        this.ingresosTotales = ingresosTotales;
        this.gastosTotales = gastosTotales;
        this.saldoFinal = saldoFinal;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public Integer getIngresosTotales() {
        return ingresosTotales;
    }

    public Integer getGastosTotales() {
        return gastosTotales;
    }

    public Integer getSaldoFinal() {
        return saldoFinal;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setIngresosTotales(Integer ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public void setGastosTotales(Integer gastosTotales) {
        this.gastosTotales = gastosTotales;
    }

    public void setSaldoFinal(Integer saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
