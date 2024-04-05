package ModelsDAO;

import ConfigBD.Conexion;
import Interfaces.CRUD;
import Models.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Artista p = new Artista();

    @Override
    public List listar() {
        ArrayList<Artista> list = new ArrayList<>();
        String sql = "select * from artistas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Artista per = new Artista();
                per.setID(rs.getInt("ID"));
                per.setNombre(rs.getString("Nombre"));
                per.setPaisOrigen(rs.getString("PaisOrigen"));
                per.setEstiloMusical(rs.getString("EstiloMusical"));
                list.add(per);

            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Artista list(int ID) {
        String sql = "select * from artistas where ID=" + ID;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setID(rs.getInt("ID"));
                p.setNombre(rs.getString("Nombre"));
                p.setPaisOrigen(rs.getString("PaisOrigen"));
                p.setEstiloMusical(rs.getString("EstiloMusical"));

            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Artista art) {
        String sql = "insert into artistas(ID, Nombre, PaisOrigen, EstiloMusical)values('" + art.getID() + "','" + art.getNombre() + "','" + art.getPaisOrigen() + "','" + art.getEstiloMusical() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Artista art) {
        String sql = "update artistas set Nombre='" + art.getNombre() + "', PaisOrigen='" + art.getPaisOrigen() + "', EstiloMusical='" + art.getEstiloMusical() + "' where ID=" + art.getID();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int ID) {
        String sql = "delete from artistas where ID=" + ID;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
