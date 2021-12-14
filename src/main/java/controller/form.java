/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import publistore.datos.dao.ServicioDao;
import publistore.datos.entidades.Servicio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oscar
 */
public class form extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (request.getParameter("codServicio") == null)
                ? 0
                : Integer.parseInt(request.getParameter("codServicio"));
        Servicio s;
        String titulo;
        String descripcion;

        ServicioDao dao = new ServicioDao();

        if (id > 0) {
            s = dao.getServicio(id);
            titulo = "Modificar Servicio";
            descripcion = "Aquí podrá modificar los datos del Servicio";
        } else {
            s = new Servicio();
            titulo = "Crear Servicio";
            descripcion = "Aquí podra agregar los datos del Servicio";
        }

        request.setAttribute("servicio", s);
        request.setAttribute("desc", descripcion);
        request.setAttribute("titulo", titulo);

        request.getRequestDispatcher("formulario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codServicio = Integer.valueOf(request.getParameter("codServicio"));
        String nombre = request.getParameter("nombre");
        float precio = Float.valueOf(request.getParameter("precio"));
        int cantidad = Integer.valueOf(request.getParameter("cant"));
        String mensaje = request.getParameter("msg");
        String msg = "";
        Servicio s = new Servicio(codServicio, nombre, precio, cantidad);
        ServicioDao dao = new ServicioDao();
        if (mensaje.equals("Modificar Servicio")) {
            msg = dao.modServicio(s);
        } else {
            msg = dao.addServicio(s, mensaje);
        }
        if (msg.equals("exito")) {
            String url = request.getContextPath() + "/admin/gestionar.jsp";
            response.sendRedirect(url);
        } else {
            String url = request.getContextPath() + "/admin/errorRegistro.jsp";
            response.sendRedirect(url);
        }
    }

}
