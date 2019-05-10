package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class platillosDAO {
    private int id_platillo;
    private String nom_menu;
    private String descripcion;
    private int precio;
    private String url_platillos;

    public int getId_platillo() {
        return id_platillo;
    }

    public void setId_platillo(int id_platillo) {
        this.id_platillo = id_platillo;
    }

    public String getNom_menu() {
        return nom_menu;
    }

    public void setNom_menu(String nom_menu) {
        this.nom_menu = nom_menu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUrl_platillos() {
        return url_platillos;
    }

    public void setUrl_platillos(String url_platillos) {
        this.url_platillos = url_platillos;
    }

    public void INSERTAR(){
        String consulta = "INSERT INTO platillos(descripcion,precio,imagen,id_menu)) " +
                "VALUES('"+descripcion+"',"+precio+",'"+url_platillos+"',(SELECT id_menu FROM menu WHERE nombre = '"+nom_menu+"')";
        try {
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ACTUALIZAR(){
        String consulta = "UPDATE platillos SET id_menu = (SELECT id_menu FROM menu WHERE nombre = '"+nom_menu+"', descripcion = '"+descripcion +
                "' precio = "+precio+",imagen='"+url_platillos+"') where" +
                " id_platillo = "+id_platillo;
        try {
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ELIMINAR(){
        String consulta = "DELETE FROM platillos WHERE id_platillos = "+id_platillo;
        try {
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<platillosDAO> SELECCIONAR(){

        ObservableList<platillosDAO> lista = FXCollections.observableArrayList();
        platillosDAO objPLDAO = null;

        String consulta = "SELECT id_platillo, descripcion, precio, imagen, (SELECT id_menu as nombre FROM menu WHERE nombre = '"+nom_menu+"') FROM platillos ORDER BY descripcion";
        try{
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(consulta);
            while(res.next()){
                objPLDAO = new platillosDAO();
                objPLDAO.id_platillo   = res.getInt("id_platillo");
                objPLDAO.descripcion   = res.getString("descripcion");
                objPLDAO.precio        = res.getInt("precio");
                objPLDAO.url_platillos = res.getString("imagen");
                objPLDAO.nom_menu        = res.getString("nombre");
                lista.add(objPLDAO);
            }
        }
        catch (Exception e){}

        return lista;
    }
}