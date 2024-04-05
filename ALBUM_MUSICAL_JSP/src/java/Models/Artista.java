package Models;

public class Artista {

    int ID;
    String Nombre;
    String PaisOrigen;
    String EstiloMusical;

    public Artista() {
    }

    public Artista(int ID, String Nombre, String PaisOrigen, String EstiloMusical) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.PaisOrigen = PaisOrigen;
        this.EstiloMusical = EstiloMusical;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaisOrigen() {
        return PaisOrigen;
    }

    public void setPaisOrigen(String PaisOrigen) {
        this.PaisOrigen = PaisOrigen;
    }

    public String getEstiloMusical() {
        return EstiloMusical;
    }

    public void setEstiloMusical(String EstiloMusical) {
        this.EstiloMusical = EstiloMusical;
    }

}
