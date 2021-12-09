/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publistore.datos.dao.DetalleDao;
import publistore.datos.dao.FacturaDao;
import publistore.datos.dao.ServicioDao;
import publistore.datos.entidades.Detalles;
import publistore.datos.entidades.Factura;
import publistore.datos.entidades.Servicio;

/**
 *
 * @author Oscar
 */
public class comprar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codServicio = Integer.valueOf(request.getParameter("id"));
        
        ServicioDao dao = new ServicioDao();
        Servicio p = dao.getServicio(codServicio);
        
        request.setAttribute("servicio", p);
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cedula = (int)request.getSession().getAttribute("cedula");
        int codServicio = Integer.valueOf(request.getParameter("codServicio"));
        String nombre = request.getParameter("nombre");
        float precio = Float.valueOf(request.getParameter("precio"));
        int cantidad = Integer.valueOf(request.getParameter("cant"));
        
        float descuento = 0;
        float total = precio*cantidad;
        //int iva = 19;
        if(cantidad>3)
            descuento = (total*15)/100; //15% de descuento
                
        
        DetalleDao detalle = new DetalleDao();
        FacturaDao factura = new FacturaDao();
        ServicioDao servicio = new ServicioDao();
        
        Servicio s = servicio.getServicio(codServicio);
        Detalles d = new Detalles(0,codServicio, /*iva,*/ descuento, total);
        detalle.crearDetalle(d);
        
        d.setNombreServicio(s.getNombre());
        d.setPrecioServicio(s.getPrecio());
        s.setCantidad(s.getCantidad() - cantidad);
        servicio.addServicio(s, "Modificar Servicio");
        
        Factura f = new Factura(0,cedula, detalle.getMax());
        factura.crearFactura(f);
        
        
        
        request.setAttribute("factura", f);
        request.setAttribute("detalle", d);
        request.setAttribute("cantidad", cantidad);
        request.getRequestDispatcher("factura.jsp").forward(request, response);
    }
}
