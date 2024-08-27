package dao.interfaces;

import java.util.List;
import model.Categoria;

public interface CategoriasDAO {
    public void EliminarCategorias(int id);
    public List<Categoria> ObtenerCategorias();
    public void CrearCategorias(Categoria categoria);
    public void ActualizarCategorias(Categoria categoria, int id);
}
