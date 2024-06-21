<%-- 
    Document   : Nosotros
    Created on : 6 jun. 2024, 11:07:38
    Author     : efe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Artensany</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp" >Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?accion=productos">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Carrito de Compras</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                    <ul class='navbar-nav'>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Iniciar Sesion
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section id="nosotros" class="container py-5">
            <h2 class="text-center mb-4">Nosotros</h2>
            <div class="row">
                <div class="col-lg-6">
                    <h3>Nuestra Historia</h3>
                    <p>Somos Artesanías "Culture", una empresa familiar dedicada a la creación de hermosas piezas artesanales desde 1995. Con sede en el campo, encontramos inspiración en la naturaleza que nos rodea.</p>
                    <h3>Nuestra Misión</h3>
                    <p>Nuestra misión es ofrecer productos artesanales únicos y de alta calidad que reflejen la belleza y el amor por la artesanía. Nos esforzamos por preservar las técnicas tradicionales de fabricación y promover la sostenibilidad en todo lo que hacemos.</p>
                </div>
                <div class="col-lg-6">
                    <h3>Nuestro Proceso</h3>
                    <p>Cada una de nuestras piezas artesanales se crea con cuidado y atención al detalle. Utilizamos materiales de origen local siempre que sea posible y nos esforzamos por minimizar nuestro impacto ambiental en cada etapa del proceso de fabricación.</p>
                    <h3>Testimonios</h3>
                    <blockquote class="blockquote">
                        <p class="mb-0">"He comprado varias piezas de Artesanías "Culture" y siempre estoy impresionado por la calidad y la atención al detalle. ¡Definitivamente recomendaría sus productos a cualquiera que busque artesanías únicas y hermosas!"</p>
                        <footer class="blockquote-footer">José Pérez, Cliente Satisfecho</footer>
                    </blockquote>
                </div>
            </div>
        </section>

        <footer class="bg-dark text-white text-center py-3">
            <p>Artesanías El Encanto &copy; 2024</p>
        </footer>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#" >Nosotros</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?accion=productos">Contacto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Redes Sociales</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
