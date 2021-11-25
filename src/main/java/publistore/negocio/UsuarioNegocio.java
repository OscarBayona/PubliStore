/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publistore.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import publistore.datos.dao.UsuarioDao;
import publistore.datos.entidades.Usuario;

/**
 *
 * @author RYZEN
 */
public class UsuarioNegocio {
    private UsuarioDao usuarioDao;

    public UsuarioNegocio() {
        usuarioDao = new UsuarioDao();
    }

    public List<Usuario> getUsuarios(){
        List<Usuario> asistentes = new ArrayList<Usuario>();
        try {
            asistentes = usuarioDao.getUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            asistentes=null;
        }                
        
        return asistentes;
    }
    
    public boolean guardarUsuario(Usuario usuario) throws SQLException{
        boolean rta = usuarioDao.guardarUsuario(usuario);
        return rta;
    }
    
}
