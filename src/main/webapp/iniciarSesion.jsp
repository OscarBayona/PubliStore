<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Hoja de estilos -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
        <link rel="stylesheet" href="css/styles.css" />
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
                        <h5>Sistema de gesti�n</h5>
                    </section>
                    <section class="col-md-4">
                        <img src="img/Logo.png" alt="" width="55%" id="math" />
                    </section>
                </section>
            </header>
            <hr />

            <div class="container">
            <div class="card mt-3">
                <div class="card-header">
                    <h3>Ingrese sus datos de inicio de sesi�n</h3>
                </div>
                <div class="card-body">
                    <form action="inicioSesion" method="post">
                        <div class="row gy-3">
                            <div class="col-3">
                                <div class="form-floating">
                                    <input type="number" class="form-control" id="cedula" name="cedula" placeholder="101010010">
                                    <label for="floatingInput">Ingrese su c�dula</label>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-floating">
                                    <input type="password" class="form-control" id="pass" name="pass" placeholder="1234">
                                    <label for="floatingPassword">Ingrese su contrase�a</label>
                                </div>
                            </div>
                            <div class="col-3">
                                <button type="submit" class="btn btn-primary">Iniciar</button>
                                <a href="index.html" class="btn btn-primary">Volver</a>
                            </div>
                        </div>
                    </form>
                </div>                
            </div>
            <hr />
            <footer>
                Desarrollado por: Oscar Bayona-1151906
                <a href="https://ingsistemas.cloud.ufps.edu.co/" target="_blank"><img src="img/sistemas.jpg" alt="Sistemas" /></a>
            </footer>
        </div>
    </body>
</html>
