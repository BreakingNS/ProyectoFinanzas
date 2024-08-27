package logica;

public class ResumenAnual {
    private int id;
    private Integer anio;
    private Integer ingresosAnuales;
    private Integer gastosAnuales;
    private Integer saldoAnual;

    public ResumenAnual() {
    }

    public ResumenAnual(int id, Integer anio, Integer ingresosAnuales, Integer gastosAnuales, Integer saldoAnual) {
        this.id = id;
        this.anio = anio;
        this.ingresosAnuales = ingresosAnuales;
        this.gastosAnuales = gastosAnuales;
        this.saldoAnual = saldoAnual;
    }

    public int getId() {
        return id;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getIngresosAnuales() {
        return ingresosAnuales;
    }

    public Integer getGastosAnuales() {
        return gastosAnuales;
    }

    public Integer getSaldoAnual() {
        return saldoAnual;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setIngresosAnuales(Integer ingresosAnuales) {
        this.ingresosAnuales = ingresosAnuales;
    }

    public void setGastosAnuales(Integer gastosAnuales) {
        this.gastosAnuales = gastosAnuales;
    }

    public void setSaldoAnual(Integer saldoAnual) {
        this.saldoAnual = saldoAnual;
    }
}
