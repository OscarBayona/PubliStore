<%-- 
    Document   : nosotros
    Created on : 13/12/2021, 10:31:32 PM
    Author     : Oscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Hoja de estilos -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/styles.css" />
        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
                integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
                integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
        crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        
        <title>StoresWeb</title>
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
            <hr />

            
            <div class="container-md">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="<%=request.getContextPath() %>/cliente/index.jsp">Inicio</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="<%=request.getContextPath() %>/cliente/consultar.jsp">Consultar Servicios</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath() %>/cliente/nosotros.jsp">Nosotros</a>
                                </li>
                            </ul>
                            <form class="d-flex">
                                <a class="btn btn-light"><%=request.getSession().getAttribute("nombre") %></a>
                                <a href="<%=request.getContextPath() %>/cerrarSesion" class="btn btn-primary">Cerrar Sesión</a>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
                            <br>
                <div class="container">
                    <div class="card mb-3">
                        <img src="../img/reunion.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">EL MAYOR VALOR QUE TIENE PUBLISTORE SON LAS PERSONAS QUE LO FORMAN</h5>
                        <p class="card-text">Ponemos al servicio de nuestros clientes una riqueza fruto de la suma de cada componente, por ello tratamos de generar un entorno en el que todos los profesionales se sientan integrados y realizados. </p>
                             <p class="card-text">El objetivo del cliente se convierte en objetivo de PUBLISTORE. La consecución del objetivo se convierte en un éxito personal para las personas de PUBLISTORE, con independencia de la dimensión del proyecto. Este proceso alimenta la ilusión en PUBLISTORE. </p>
                             <p class="card-text">Desde la herencia recibida de compromiso con el trabajo y responsabilidad ante la confianza de las personas, se trazó la dirección hacia una arquitectura de servicio. Dicha dirección quiere buscar posicionamiento fundamental hacia el mundo social.</p>
                             <p class="card-text">Estamos orgullosos de poder poner a disposición de nuestros clientes un equipo de gran calidad humana.</p>
                        
                    </div>
                    </div>
                </div>
            <hr />
            <footer>
                Desarrollado por: Oscar Bayona-1151906
                <a href="https://ingsistemas.cloud.ufps.edu.co/" target="_blank"><img src="../img/sistemas.jpg" alt="Sistemas" /></a>
            </footer>
        </div>
    </body>
</html>
