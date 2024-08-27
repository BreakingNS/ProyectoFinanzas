package dao.impl;

import dao.interfaces.CategoriasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;

public class CategoriasDAOImpl implements CategoriasDAO{
    
    private Connection connection = null;
    private String SENTENCIA_ELIMINAR_CATEGORIA = "DELETE FROM Finanzas.categoria WHERE id = ?";
    private String SENTENCIA_OBTENER_CATEGORIA = "SELECT * FROM Finanzas.categoria";
    private String SENTENCIA_CREAR_CATEGORIA = "INSERT INTO Finanzas.categoria (nombre) VALUES ( ? )";
    private String SENTENCIA_ACTUALIZAR_CATEGORIA = "UPDATE Finanzas.categoria SET nombre = ? WHERE id = ?";


    public CategoriasDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void EliminarCategorias(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_CATEGORIA);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Categoria> ObtenerCategorias() {
        List<Categoria> listaCategorias = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_CATEGORIA);
            ResultSet categoria_Resultado = preparedStatement.executeQuery();
            
            while (categoria_Resultado.next()){
                String nombreCategoria = categoria_Resultado.getString("nombre");
                int idCategoria = categoria_Resultado.getInt("id");
                
                Categoria categoria = new Categoria(idCategoria, nombreCategoria);
                
                listaCategorias.add(categoria);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCategorias;
    }

    @Override
    public void CrearCategorias(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_CATEGORIA);
            preparedStatement.setString(1, categoria.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ActualizarCategorias(Categoria categoria, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_CATEGORIA);
            preparedStatement.setString(1, categoria.getNombre());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
