<%-- 
    Document   : form
    Created on : 9/12/2021, 12:47:44 AM
    Author     : Oscar
--%>
<%@page import="publistore.datos.entidades.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Comprar Producto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="../css/styles.css" rel="stylesheet">
    </head>
    <div class="container">
            <header>
                <section class="main row">
                    <section class="col-md-8">
                        <h1>PubliStoresWeb</h1>
                        
                    </section>
                    <section class="col-md-4">
                        <img src="../img/Logo.png" alt="" width="55%" id="math" />
                    </section>
                </section>
            </header>
        </div>
        <hr />
        <div class="container">
            <div class="card mt-3">
                <div class="card-header">
                    <h3>Escoje la cantidad y finaliza tu compra</h3>
                    <h4>Compra más de 3 productos y recibe 15% de descuento!!</h4>
                </div>
                <div class="card-body">
                    <%
                        Servicio p = (Servicio) request.getAttribute("servicio");
                    %>
                    <form action="comprar.do" method="post">
                        <div class="row gy-3">
                            <div class="col-3 ">
                                <div class="form-floating">
                                    <input type="number" class="form-control" id="codProducto" name="codServicio" placeholder="1484981" readonly
                                            value="<%=p.getCodServicio() %>" required>
                                    <label for="floatingInput">Ingrese el código del Servicio</label>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-floating">
                                    <input type="text" value="<%=p.getNombre()%>" class="form-control" id="nombre" name="nombre" placeholder="Publicidad " readonly required>
                                    <label for="floatingPassword">Ingrese el nombre del producto</label>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-floating">
                                    <input type="number" value="<%=p.getPrecio()%>" class="form-control" id="precio" name="precio" placeholder="10000" readonly required>
                                    <label for="floatingPassword">Ingrese el precio unitario</label>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-floating">
                                    <input type="number" class="form-control" id="cant" name="cant" placeholder="10" max="<%=p.getCantidad() %>" required>
                                    <label for="floatingPassword">Ingrese la cantidad a comprar</label>
                                </div>
                            </div>
                            <div class="col-3">
                                <button type="submit" class="btn btn-primary">Comprar</button>
                                <a type="button" href="consultar.jsp" class="btn btn-primary">Volver</a>
                            </div>
                        </div>
                    </form>                    
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
