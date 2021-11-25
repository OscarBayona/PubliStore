/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publistore.datos.dao.UsuarioDao;
import publistore.datos.entidades.Usuario;

/**
 *
 * @author RYZEN
 */
public class addUsuario extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ced = Integer.valueOf(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dir = request.getParameter("direccion");
        String email = request.getParameter("email");
        String tipo = "Usuario";
        String pass = request.getParameter("pass");

        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario(ced, nombre, apellido, email, pass, dir, tipo);
        try {
            boolean rta = dao.guardarUsuario(u);
            request.getSession().setAttribute("title", "Registro exitoso");
            request.getSession().setAttribute("desc", "Usuario registrado con éxito");
        } catch (SQLException ex) {
            request.getSession().setAttribute("title", "Error de Registro");
            request.getSession().setAttribute("desc", "Cédula ya existe en el sistema, intente nuevamente");
        }
        request.getRequestDispatcher("exitoso.jsp").forward(request, response);
    } 

}
