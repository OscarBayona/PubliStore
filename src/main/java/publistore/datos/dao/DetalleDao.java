package publistore.datos.dao;

import publistore.datos.entidades.Detalles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import publistore.datos.Conexion;

public class DetalleDao {
    
    
    public void crearDetalle(Detalles d) {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = conexion.conectar("DetalleDao.crearDetalle");
            String sql = "INSERT INTO detalles (codServicio, descuento, total)"
                    + "VALUES (?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, d.getCodServicio());
            
            stm.setFloat(2, d.getDescuento());
            stm.setFloat(3, d.getTotal());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getMax(){
        Conexion conexion = new Conexion();
        Connection con = null;
        int max = 0;
        try {
            con = conexion.conectar("DetalleDao.getMax");
            Statement st = con.createStatement();
            String sql = "Select MAX(idDetalle) from Detalles";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                max = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("Error=" + ex);
        }
        return max;
    }
}
