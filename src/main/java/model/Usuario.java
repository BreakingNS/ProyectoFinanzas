package model;

import java.util.List;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String contrasenia;
    private List<FichaMensual> listaFichasMensuales;

    public Usuario() {
    }

    public Usuario(int id, String nombreUsuario, String contrasenia, List<FichaMensual> listaFichasMensuales) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.listaFichasMensuales = listaFichasMensuales;
    }

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<FichaMensual> getListaFichasMensuales() {
        return listaFichasMensuales;
    }

    public void setListaFichasMensuales(List<FichaMensual> listaFichasMensuales) {
        this.listaFichasMensuales = listaFichasMensuales;
    }
    
    
}
