package dao.interfaces;

public interface ConexionDataBaseDAO {
    
    public void crearBaseDatos(String nombre);
    public void eliminarBaseDatos(String nombre);
    public boolean existeBaseDatos(String nombre);
    public void crearTablas();
    public void eliminarTablas();
    public boolean existeTabla(String nombre);
    // Otros métodos relacionados con la gestión de bases de datos completas, si es necesario

}
