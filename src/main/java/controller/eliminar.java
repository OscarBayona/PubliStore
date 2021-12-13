/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import publistore.datos.entidades.Servicio;
import publistore.datos.dao.ServicioDao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oscar
 */
public class eliminar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        
        ServicioDao dao = new ServicioDao();
        Servicio s = new Servicio();
        s.setCodServicio(id);
                
        request.setAttribute("msg", dao.eliminar(s));
        request.getRequestDispatcher("gestionar.jsp").forward(request, response);
    }

}
