<%-- 
    Document   : consultar
    Created on : 8/12/2021, 10:31:52 PM
    Author     : Oscar
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigInteger"%>

<%@page import="publistore.datos.entidades.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet">
        <jsp:include page="../mostrarServ"></jsp:include>
        <title>Servicios</title>
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
                        <img src="../img/Logo.png" alt="" width="55%" id="math" />
                    </section>
                </section>
            </header>
        </div>
        <div class="container">
            <div class="card mt-3">
                <div class="card-header">
                    <h3>Aquí podrás adquirir nuestros servicios</h3>
                </div>
                <div class="card-body">
                    <a href="index.jsp" class="btn btn-success">Volver</a>
                    <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Total</th>
                            <th scope="col">Comprar</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <%                    
                            ArrayList<Servicio> lista = (ArrayList<Servicio>) request.getAttribute("lista");
                            for (Servicio s : lista) {
                        %>
                        <tr>
                            <th scope="row"><%=s.getCodServicio() %></th>
                            <td><%=s.getNombre()%></td>
                            <td><%=s.getPrecio()%></td>
                            <td><%=s.getCantidad()%></td>
                            <td><%=(int) (s.getCantidad() * s.getPrecio()) %></td>                            
                            <td><a onclick="return confirm('¿Seguro que desea comprar?');" 
                                class="btn btn-success" href="comprar.do?id=<%=s.getCodServicio() %>">Comprar</a></td>
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
