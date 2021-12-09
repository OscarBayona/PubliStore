/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publistore.datos.dao;
import publistore.datos.entidades.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import publistore.datos.Conexion;
/**
 *
 * @author Oscar
 */
public class ServicioDao {
    private Connection conn;

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public Connection getConnection() {
        if (conn == null) {
            conn = new Conexion().getConnection();
        }
        return conn;
    }

    public void closeConnection() {
        try {
            getConnection().close();
            conn = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Servicio getServicio(int codServicio) {
        Servicio s = null;
        try {
            PreparedStatement stm = getConnection().prepareStatement(
                    "SELECT * FROM servicio where codServicio = ?");
            stm.setInt(1, codServicio);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                s = new Servicio();
                s.setCodServicio(rs.getInt("codServicio"));
                s.setNombre(rs.getString("nombre"));
                s.setCantidad(rs.getInt("cantidad"));
                s.setPrecio(rs.getFloat("precio"));
            }
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<Servicio> getServicios() {
        ArrayList<Servicio> lista = new ArrayList<Servicio>();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM servicio");
            while (rs.next()) {
                Servicio s = new Servicio();
                s.setCodServicio(rs.getInt("codServicio"));
                s.setNombre(rs.getString("nombre"));
                s.setCantidad(rs.getInt("cantidad"));
                s.setPrecio(rs.getFloat("precio"));
                lista.add(s);
            }
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String addProducto(Servicio s, String msg) {
        PreparedStatement stm = null;
        try {
            String sql;
            if (msg.equals("Modificar Servicio")) {
                sql = "UPDATE SERVICIO set nombre=?,cantidad=?,precio=? WHERE codServicio=?";
                stm = getConnection().prepareStatement(sql);
            } else {
                sql = "INSERT INTO SERVICIO (nombre,cantidad,precio,codServicio) VALUES (?,?,?,?)";
                stm = getConnection().prepareStatement(sql);
            }
            stm.setString(1, s.getNombre());
            stm.setInt(2, s.getCantidad());
            stm.setFloat(3, s.getPrecio());
            stm.setInt(4, s.getCodServicio());

            stm.executeUpdate();
            stm.close();
            return "exito";
        } catch (SQLException ex) {
            return "error";
        }
    }
    
    public String eliminar(Servicio s) {
        try {
            PreparedStatement stm = getConnection().prepareStatement(
                    "DELETE FROM PRODUCTO WHERE codproducto=?");
            stm.setInt(1, s.getCodServicio());
            stm.executeUpdate();
            stm.close();
            return "exito";
        } catch (SQLException e) {
            return "error";
        }
    } 
}
