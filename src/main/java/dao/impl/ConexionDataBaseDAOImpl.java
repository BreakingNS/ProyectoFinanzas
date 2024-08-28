package dao.impl;

import dao.interfaces.ConexionDataBaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDataBaseDAOImpl implements ConexionDataBaseDAO{
    
    private Connection connection = null;
    private final String SENTENCIA_CREAR_DATABASE = 
            "CREATE SCHEMA IF NOT EXISTS Finanzas";
    private final String SENTENCIA_ELIMINAR_DATABASE = 
            "DROP SCHEMA IF EXISTS Finanzas CASCADE;";
    private final String SENTENCIA_EXISTE_DATABASE = 
            "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = ?";
    private static final String SENTENCIA_CREAR_TABLA_CATEGORIA = 
            "CREATE TABLE IF NOT EXISTS Finanzas.categoria ("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "nombre VARCHAR(25) NOT NULL, "
            + "tipo VARCHAR(20) NOT NULL"
            + ")";
    private static final String SENTENCIA_CREAR_TABLA_GASTO = 
            "CREATE TABLE IF NOT EXISTS Finanzas.gasto ("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "monto INT NOT NULL, "
            + "descripcion VARCHAR(255), "
            + "fecha DATE NOT NULL, "
            + "categoria_id INT, "
            + "FOREIGN KEY (categoria_id) REFERENCES Finanzas.categoria(id)"
            + ")";
    private static final String SENTENCIA_CREAR_TABLA_INGRESO = 
            "CREATE TABLE IF NOT EXISTS Finanzas.ingreso ("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "monto INT NOT NULL, "
            + "descripcion VARCHAR(255), "
            + "fecha DATE NOT NULL, "
            + "categoria_id INT, "
            + "FOREIGN KEY (categoria_id) REFERENCES Finanzas.categoria(id)"
            + ")";
    private static final String SENTENCIA_CREAR_TABLA_USUARIO = 
            "CREATE TABLE IF NOT EXISTS Finanzas.usuario ("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "nombreUsuario VARCHAR(20) NOT NULL, "
            + "contraseña VARCHAR(20) NOT NULL"
            + ")";
    private static final String SENTENCIA_CREAR_TABLA_RESUMENANUAL = 
            "CREATE TABLE IF NOT EXISTS Finanzas.resumenanual ("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "anio INT NOT NULL, "
            + "ingresosAnuales INT NOT NULL, "
            + "gastosAnuales INT NOT NULL, "
            + "saldoAnual INT NOT NULL"
            + ")";
    private static final String SENTENCIA_CREAR_TABLA_FICHAMENSUAL = 
            "CREATE TABLE IF NOT EXISTS Finanzas.fichamensual ("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "mes INT NOT NULL, "
            + "anio INT NOT NULL, "
            + "ingresosTotales INT NOT NULL, "
            + "gastosTotales INT NOT NULL, "
            + "saldoFinal INT NOT NULL, "
            + "usuario_id INT, "
            + "FOREIGN KEY (usuario_id) REFERENCES Finanzas.usuario(id), "
            + "resumen_anual_id INT, "
            + "FOREIGN KEY (resumen_anual_id) REFERENCES Finanzas.resumenanual(id)"
            + ")";

    public ConexionDataBaseDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearBaseDatos(String nombre) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_DATABASE);
            preparedStatement.executeUpdate();  // Ejecuta la sentencia SQL para crear el esquema
            preparedStatement.close();  // Cierra el PreparedStatement después de usarlo
            crearTablas();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDataBaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarBaseDatos(String nombre) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_DATABASE);
            preparedStatement.executeUpdate();  // Ejecuta la sentencia SQL para crear el esquema
            preparedStatement.close();  // Cierra el PreparedStatement después de usarlo
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDataBaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean existeBaseDatos(String nombre) {
        boolean existe = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_EXISTE_DATABASE);
            preparedStatement.setString(1, nombre);  // Establece el nombre del esquema a buscar
            ResultSet resultSet = preparedStatement.executeQuery();  // Ejecuta la consulta

            if (resultSet.next()) {
                existe = true;  // Si hay un resultado, el esquema existe
            }

            resultSet.close();  // Cierra el ResultSet
            preparedStatement.close();  // Cierra el PreparedStatement

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDataBaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;  // Retorna true si el esquema existe, false si no
    }

    @Override
    public void crearTablas() {
        try {
            // Iniciar transacción
            connection.setAutoCommit(false);

            // Crear tablas
            try (
                 PreparedStatement preparedStatement1 = connection.prepareStatement(SENTENCIA_CREAR_TABLA_CATEGORIA);
                 PreparedStatement preparedStatement2 = connection.prepareStatement(SENTENCIA_CREAR_TABLA_GASTO);
                 PreparedStatement preparedStatement3 = connection.prepareStatement(SENTENCIA_CREAR_TABLA_INGRESO);
                 PreparedStatement preparedStatement4 = connection.prepareStatement(SENTENCIA_CREAR_TABLA_USUARIO);
                 PreparedStatement preparedStatement5 = connection.prepareStatement(SENTENCIA_CREAR_TABLA_RESUMENANUAL);
                 PreparedStatement preparedStatement6 = connection.prepareStatement(SENTENCIA_CREAR_TABLA_FICHAMENSUAL)) {

                preparedStatement1.executeUpdate();
                preparedStatement2.executeUpdate();
                preparedStatement3.executeUpdate();
                preparedStatement4.executeUpdate();
                preparedStatement5.executeUpdate();
                preparedStatement6.executeUpdate();

                // Confirmar transacción
                connection.commit();
            } catch (SQLException e) {
                // Revertir en caso de error
                connection.rollback();
                throw e;
            } finally {
                // Restaurar auto-commit
                connection.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDataBaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void eliminarTablas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeTabla(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
