package app;

import config.ConexionDateBase;
import dao.impl.CategoriasDAOImpl;
import java.sql.Connection;
import java.util.List;
import model.Categoria;

public class ProyectoFinanzas {

    public static void main(String[] args) throws ClassNotFoundException {
        ConexionDateBase conexionDataBase = new ConexionDateBase();
        
        CategoriasDAOImpl categoriaDAO = new CategoriasDAOImpl(conexionDataBase.getConexionDBH2());
        
        List<Categoria> listaCategorias = null;
        
        listaCategorias = categoriaDAO.ObtenerCategorias();
        
        for(Categoria cata : listaCategorias){
            System.out.println("---------------------------------------------------");
            System.out.println("Id: " + cata.getId());
            System.out.println("Nombre: " + cata.getNombre());
        }
    }
}
