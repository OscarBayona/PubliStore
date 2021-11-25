/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publistore.datos.dao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import publistore.datos.Conexion;
import publistore.datos.entidades.Usuario;

/**
 *
 * @author RYZEN
 */
public class UsuarioDao implements Serializable{
    
    
    public boolean guardarUsuario(Usuario usuario) throws SQLException{
        boolean rta=false;
        Conexion conexion = new Conexion();
        Connection con=null;
        PreparedStatement ps=null;
        try{
            
            con = conexion.conectar("UsuarioDao.guardarUsuario");
            String sql = "INSERT INTO usuario (cedula, nombre, apellido, email, contraseña, direccion, rol) VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getContraseña());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getRol());              

            ps.execute();
            rta=true;
            
            ps.close();
            ps=null;

            con.close();
            con=null;
        } catch(Exception e){
            e.printStackTrace();
            rta=false;            
            ps=null;            
            con=null;
        }                
        
        return rta;
    }
    
    public Usuario getUsuario(int cedula){
        Conexion conexion = new Conexion();
        Connection con = null;
        Usuario u = null;
        try {
            con = conexion.conectar("UsuarioDao.getUsuario");
            PreparedStatement stm = con.prepareStatement(
                    "SELECT * FROM usuario where cedula = ?");
            stm.setInt(1, cedula);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                u = new Usuario();
                u.setCedula(rs.getInt("cedula"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));
            }
            stm.close();
            
        } catch (Exception e) {
              e.printStackTrace();
        }
        return u;
    }
    
    public List<Usuario> getUsuarios() throws Exception{
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar("UsuarioDao.getUsuarios");
        String sql = "SELECT * FROM usuario";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rst = ps.executeQuery();
        
        while (rst.next()){
            Usuario usuario = new Usuario();
            usuario.setCedula(rst.getInt(1));
            usuario.setNombre(rst.getString(2));
            usuario.setApellido(rst.getString(3));
            usuario.setEmail(rst.getString(4));
            usuario.setContraseña(rst.getString(5));
            usuario.setDireccion(rst.getString(6));
            usuario.setRol(rst.getString(7));
            
            usuarios.add(usuario);
        }
        rst.close();
        rst=null;
        
        ps.close();
        ps=null;
        
        con.close();
        con=null;
        
        return usuarios;
    }
    
}
