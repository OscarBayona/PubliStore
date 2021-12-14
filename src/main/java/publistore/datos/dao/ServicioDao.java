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
    

    public Servicio getServicio(int codServicio) {
        Conexion conexion = new Conexion();
        Connection con = null;
        Servicio s = null;
        try {
            con = conexion.conectar("ServicioDao.getServicio");
            PreparedStatement stm = con.prepareStatement(
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

    public ArrayList<Servicio> getServicios() throws SQLException {
        ArrayList<Servicio> lista = new ArrayList<Servicio>();
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar("ServicioDao.getServicios");
        
            
            String sql = "SELECT * FROM servicio";
            PreparedStatement ps = con.prepareStatement(sql);
         
         ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Servicio s = new Servicio();
                s.setCodServicio(rs.getInt("codServicio"));
                s.setNombre(rs.getString("nombre"));
                s.setCantidad(rs.getInt("cantidad"));
                s.setPrecio(rs.getFloat("precio"));
                lista.add(s);
            }
            

        
        rs.close();
        rs=null;
        
        ps.close();
        ps=null;
        
        con.close();
        con=null;
        return lista;
    }

    public String addServicio(Servicio s, String msg) {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = conexion.conectar("ServicioDao.addServicio");
            String sql;
            if (msg.equals("Modificar Servicio")) {
                sql = "UPDATE SERVICIO set nombre=?,cantidad=?,precio=? WHERE codServicio=?";
                stm = con.prepareStatement(sql);
            } else {
                sql = "INSERT INTO SERVICIO (nombre,cantidad,precio,codServicio) VALUES (?,?,?,?)";
                stm = con.prepareStatement(sql);
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
        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar("ServicioDao.eliminar");
            PreparedStatement stm = con.prepareStatement(
                    "DELETE FROM SERVICIO WHERE codServicio=?");
            stm.setInt(1, s.getCodServicio());
            stm.executeUpdate();
            stm.close();
            return "exito";
        } catch (SQLException e) {
            return "error";
        }
    } 
}
