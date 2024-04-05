package Interfaces;

import Models.Artista;
import java.util.List;

public interface CRUD {

    public List listar();

    public Artista list(int ID);

    public boolean add(Artista art);

    public boolean editar(Artista art);

    public boolean eliminar(int ID);

}
