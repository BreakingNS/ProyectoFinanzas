package app;

import config.ConexionDateBase;
import config.CreacionDataBase;
import dao.impl.CategoriasDAOImpl;
import dao.impl.ConexionDataBaseDAOImpl;
import java.sql.Connection;
import java.util.List;
import model.Categoria;

public class ProyectoFinanzas {

    public static void main(String[] args) throws ClassNotFoundException {
        
        ConexionDateBase conexionDataBase = new ConexionDateBase();
        
        ConexionDataBaseDAOImpl creacionDataBase = new ConexionDataBaseDAOImpl(conexionDataBase.getConexionDBH2());
        
        creacionDataBase.crearBaseDatos("Finanzas");
        
        /*
        for(Categoria cata : listaCategorias){
            System.out.println("---------------------------------------------------");
            System.out.println("Id: " + cata.getId());
            System.out.println("Nombre: " + cata.getNombre());
        }*/
    }
}
