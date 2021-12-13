<%-- 
    Document   : gestionar
    Created on : 13/12/2021, 12:22:25 AM
    Author     : Oscar
--%>
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
        
        <jsp:include page="../mostrarServ"></jsp:include>
            <title>Gestion de servicios</title>
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
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
                    if (msg.equals("exito")) {
                        
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Servicio eliminado con éxito
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%} else {
            %>
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                Lo sentimos, no se ha podido borrar el servicio por que hay una venta registada.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%}
                    request.removeAttribute("msg");
                }%>
            <div class="card mt-3">
                <div class="card-header">
                    <h3>Aquí podrás gestionar los servicio actuales y añadir nuevos</h3>
                </div>
                <div class="card-body">                    
                    <a href="form.do" class="btn btn-success">Crear Servicio</a>
                    <a href="index.jsp" class="btn btn-success">Volver</a>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Total</th>
                                <th scope="col">Editar</th>
                                <th scope="col">Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                ArrayList<Servicio> lista = (ArrayList<Servicio>) request.getAttribute("lista");
                                for (Servicio s : lista) {
                            %>
                            <tr>
                                <th scope="row"><%=s.getCodServicio()%></th>
                                <td><%=s.getNombre()%></td>
                                <td><%=s.getPrecio()%></td>
                                <td><%=s.getCantidad()%></td>
                                <td><%=(int) s.getCantidad() * s.getPrecio()%></td>
                                <td><a type="button" href="form.do?codServicio=<%=s.getCodServicio()%>" class="btn btn-info">Editar</a></td>
                                <td><a onclick="return confirm('¿Seguro que desea eliminar?');" 
                                       class="btn btn-danger" href="eliminar.do?id=<%=s.getCodServicio()%>">Eliminar</a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
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
