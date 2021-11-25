/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publistore.negocio.facade;

import java.sql.SQLException;
import java.util.List;
import publistore.datos.entidades.Usuario;
import publistore.negocio.UsuarioNegocio;

/**
 *
 * @author RYZEN
 */
public class UsuarioFacade {
    private UsuarioNegocio usuarioNegocio;

    public UsuarioFacade() {
        usuarioNegocio = new UsuarioNegocio();
    }    
    
    public List<Usuario> getUsuarios(){
        return usuarioNegocio.getUsuarios();
    }
    
    public boolean guardarUsuario(Usuario usuario) throws SQLException{
        return usuarioNegocio.guardarUsuario(usuario);
    }
}
