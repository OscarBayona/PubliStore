<%-- 
    Document   : facturas
    Created on : 12/12/2021, 11:26:37 PM
    Author     : Oscar
--%>
<%@page import="publistore.datos.entidades.Factura"%>
<%@page import="java.util.ArrayList"%>
<%@page import="publistore.datos.entidades.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet">
        
        <jsp:include page="../mostrarFactura"></jsp:include>
        <title>Ver Facturas</title>
    </head>
    <body>
            <div class="container">
                <header>
                    <section class="main row">
                        <section class="col-md-8">
                            <h1>PubliStoresWeb</h1>
                            <h5>Sistema de gestión</h5>
                        </section>
                        <section class="col-md-4">
                            <img src="<%=request.getContextPath()%>/img/Logo.png" alt="PubliStore" width="55%" id="math" />
                    </section>
                </section>
            </header>
        </div>
        <div class="container">
            <div class="card mt-3">
                <div class="card-header">
                    <h3>Visualiza todas tus ventas</h3>
                </div>
                <div class="card-body">
                    <a href="index.jsp" class="btn btn-success">Volver</a>
                    <%
                        ArrayList<Factura> lista = (ArrayList<Factura>) request.getAttribute("lista");
                        if (!lista.isEmpty()) {
                    %>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Id Factura</th>
                                <th scope="col">Cédula comprador</th>
                                <th scope="col">Nombre comprador</th>
                                <th scope="col">Apellido comprador</th>
                                <th scope="col">Código servicio</th>
                                <th scope="col">Descuento</th>
                                
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                for (Factura f : lista) {
                            %>
                            <tr>
                                <th scope="row"><%=f.getIdFactura()%></th>
                                <td><%=f.getCedula()%></td>
                                <td><%=f.getNombre()%></td>
                                <td><%=f.getApellido()%></td>
                                <td><%=f.getIdServicio()%></td>
                                <td><%=f.getDescuento()%></td>
                                
                                <td><%=f.getTotal()%></td>
                            </tr>
                            <%
                                }

                            %>


                        </tbody>
                    </table>
                    <%                            } else {
                    %>
                    <h4>No se ha realizado ninguna venta, no podemos mostrarte</h4>
                    <%}%>
                </div>                
            </div>
            <hr>
            <footer>
                Desarrollado por: Oscar Bayona-1151906
                <a href="https://ingsistemas.cloud.ufps.edu.co/" target="_blank"><img src="../img/sistemas.jpg" alt="Sistemas" /></a>
            </footer>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
