<%-- 
    Document   : index
    Created on : 25 nov. 2021, 1:47:58
    Author     : RYZEN
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
                        <h1>StoresWeb</h1>
                        <h5>Sistema de gestión</h5>
                    </section>
                    <section class="col-md-4">
                        <img src="img/Logo.png" alt="" width="55%" id="math" />
                    </section>
                </section>
            </header>
            <hr />

            
            <div class="container-md">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="index.jsp">Inicio</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="#">Servicios</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Nosotros</a>
                                </li>
                            </ul>
                            <form class="d-flex">
                                <a href="<%=request.getContextPath() %>/cerrarSesion" class="btn btn-primary">Cerrar Sesión</a>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
            <hr />
            <footer>
                Desarrollado por: Oscar Bayona-1151906
                <a href="https://ingsistemas.cloud.ufps.edu.co/" target="_blank"><img src="img/sistemas.jpg" alt="Sistemas" /></a>
            </footer>
        </div>
    </body>
</html>
