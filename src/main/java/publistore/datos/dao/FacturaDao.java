package publistore.datos.dao;

import publistore.datos.entidades.Factura;
import publistore.datos.entidades.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import publistore.datos.Conexion;

public class FacturaDao {


    public void crearFactura(Factura f) {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = conexion.conectar("FacturaDao.crearFactura");
            String sql = "INSERT INTO factura (cedula, idDetalle)"
                    + "VALUES (?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, f.getCedula());
            stm.setInt(2, f.getIdDetalle());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Factura> getFactura() {
         Conexion conexion = new Conexion();
        Connection con = null;
        ArrayList<Factura> lista = new ArrayList();
        try {
            con = conexion.conectar("FacturaDao.getFactura");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select f.idfactura, f.cedula, u.nombre as userName, u.apellido,"
                    + "d.codServicio, d.descuento, d.total from factura f "
                    + "inner join usuario u ON f.cedula = u.cedula "
                    + "INNER JOIN detalles d ON f.iddetalle = d.iddetalle");
            while (rs.next()) {
                Factura f = new Factura();
                f.setIdFactura(rs.getInt("idfactura"));
                f.setCedula(rs.getInt("cedula"));
                f.setNombre(rs.getString("userName"));
                f.setApellido(rs.getString("apellido"));
                f.setIdServicio(rs.getInt("codServicio"));
                f.setDescuento(rs.getFloat("descuento"));
                f.setTotal(rs.getFloat("total"));
                lista.add(f);
            }
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
