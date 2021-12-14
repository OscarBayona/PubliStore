/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import publistore.datos.dao.UsuarioDao;
import publistore.datos.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RYZEN
 */
public class inicioSesion extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cedula = Integer.valueOf(request.getParameter("cedula"));
        String pass = request.getParameter("pass");

        UsuarioDao dao = new UsuarioDao();
        Usuario u = dao.getUsuario(cedula);
        if (u != null && u.getContraseña().equals(pass)) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("nombre", u.getNombre());
            sesion.setAttribute("apellido", u.getApellido());
            sesion.setAttribute("rol", u.getRol());

            if (u.getRol().equals("Administrador")) {
                String url = request.getContextPath() + "/admin/index.jsp";
                response.sendRedirect(url);
            } else {
                sesion.setAttribute("cedula", u.getCedula());
                request.getRequestDispatcher("/cliente/index.jsp").forward(request, response);
            }
            
        }
        String url = request.getContextPath() + "/error.jsp";
        response.sendRedirect(url);
    }

    

}
