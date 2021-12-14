/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publistore.datos;

import java.sql.SQLException;
import publistore.datos.dao.ServicioDao;
import publistore.datos.entidades.Servicio;

/**
 *
 * @author Oscar
 */
public class PruebaCon {
    public static void main(String[] args) throws SQLException {
        ServicioDao dao = new ServicioDao();
        Servicio s = new Servicio(1,"Investigación de mercado", 58000, 80);
        System.out.println(dao.modServicio(s));
    }
}
