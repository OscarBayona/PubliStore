<%-- 
    Document   : factura
    Created on : 9/12/2021, 12:38:50 AM
    Author     : Oscar
--%>
<%@page import="publistore.datos.entidades.Factura"%>
<%@page import="java.util.ArrayList"%>
<%@page import="publistore.datos.entidades.Detalles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet">
        
        <jsp:include page="../mostrarServ"></jsp:include>
            <title>Factura de compra</title>
        </head>
        <body>
        <%
            Factura f = (Factura) request.getAttribute("factura");
            Detalles d = (Detalles) request.getAttribute("detalle");
            int cantidad = (Integer) request.getAttribute("cantidad");
        %>
        <div class="container">
            <header>
                <section class="main row">
                    <section class="col-md-8">
                        <h1>PubliStoresWeb</h1>
                        
                    </section>
                    <section class="col-md-4">
                        <img src="<%=request.getContextPath()%>/img/Logo.png" alt="" width="55%" id="math" />
                    </section>
                </section>
            </header>
        </div>
        <hr />
        <div class="container">
            <div class="card mt-3">
                <div class="card-header">
                    <h3>Compra de: <%=request.getSession().getAttribute("nombre") + " " + request.getSession().getAttribute("apellido")%>  </h3>
                </div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Código del producto</th>
                                <th scope="col">Nombre Servicio</th>
                                <th scope="col">Precio Unitario</th>
                                <th scope="col">Cantidad Comprada</th>
                                <th scope="col">Total (Sin descuento)</th>
                                
                                <th scope="col">Descuento</th>
                                <th scope="col">Total a pagar</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <tr>
                                <th scope="row"><%=d.getCodServicio()%></th>
                                <td><%=d.getNombreServicio()%></td>
                                <td><%=d.getPrecioServicio()%></td>
                                <td><%=cantidad%></td>                                
                                <td><%=d.getTotal()%></td>
                                                
                                <td><%=d.getDescuento()%> </td>
                                <td><%=d.getTotal() - d.getDescuento()%></td>
                            </tr>
                        </tbody>
                    </table>
                    <a href="index.jsp" class="btn btn-success">Volver</a>
                </div>                
            </div>
            <hr>
            <footer>
                
            </footer>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
