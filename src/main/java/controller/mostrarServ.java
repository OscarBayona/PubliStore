/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publistore.datos.dao.ServicioDao;
import publistore.datos.entidades.Servicio;

/**
 *
 * @author Oscar
 */
public class mostrarServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ServicioDao dao = new ServicioDao();
            
            ArrayList<Servicio> lista = dao.getServicios();
            
            request.setAttribute("lista", lista);
        } catch (SQLException ex) {
            Logger.getLogger(mostrarServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
