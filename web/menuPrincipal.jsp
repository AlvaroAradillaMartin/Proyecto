<%-- 
    Document   : menuPrincipal
    Created on : 23 mar 2024, 13:18:16
    Author     : hp
--%>

<%@page import="modelo.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/css.css" />
        <title>Agricarrion2018</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
            />
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
            integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
            crossorigin="anonymous"
        ></script>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
            />
    </head>
    <body>
        <header>
            <nav id="nav" class="navbar navbar-expand-lg">
                <div class="container-fluid">
                    <a class="navbar-brand" id="titulo" href="index.html"
                       >SERVICIOSAGRICARRIÓN 2018
                        <img id="logo" src="imagenes/download-removebg-preview (1).png" alt="logo" />
                    </a>
                    <button
                        id="boton"
                        class="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                        >
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul
                            id="navegacion"
                            class="d-flex justify-content-around align-items-center navbar-nav"
                            >
                            <li class="nav-item">
                                <a class="nav-link active" href="Labores"
                                   >SERVICIOS AGRÍOLAS</a
                                >
                            </li>                           
                            <li class="nav-item">
                                <a
                                    class="nav-link active"
                                    href="Equipos"
                                    >NUESTROS EQUIPOS</a
                                >
                            </li>
                            <li class="nav-item">
                                <div class="btn-group">
                                    <button
                                        type="button"
                                        class="btn dropdown-toggle"
                                        data-bs-toggle="dropdown"
                                        aria-expanded="false"
                                        >
                                        <i class="bi bi-person-circle"></i>

                                    </button>
                                    <p id="ParrafoUsuario"></p>
                                    <ul class="dropdown-menu dropdown-menu-end" id="desplegable">

                                        <li>
                                            <button
                                                class="dropdown-item botonesSesion"
                                                type="button"
                                                data-bs-toggle="modal"
                                                data-bs-target="#exampleModal"
                                                >
                                                Iniciar Sesión
                                            </button>
                                        </li>
                                        <li>
                                            <button
                                                class="dropdown-item botonesSesion"
                                                type="button"
                                                data-bs-toggle="modal"
                                                data-bs-target="#exampleModaltwo"
                                                >
                                                Crear Cuenta
                                            </button>
                                        </li>
                                        <li id="gestion">
                                            <a href="cliente/Gestionar" class="dropdown-item botonesSesion">
                                                Gestionar Cuenta</a>

                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div
            class="modal fade"
            id="exampleModal"
            tabindex="-1"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
            >
            <div class="modal-dialog">
                <div class="modal-content" id="modal">
                    <div class="modal-header">
                        <h1
                            class="modal-title fs-5 d-flex justify-content-center"
                            id="exampleModalLabel"
                            >
                            <i class="bi bi-person-circle"></i> INICIAR SESIÓN
                        </h1>
                        <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"
                            ></button>
                    </div>
                    <div class="modal-body">
                        <form action="Login" method="post" onsubmit="return validarLogin()">
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="UsuarioLogin"
                                    placeholder="name@example.com"
                                    name="usuarioLogin"
                                    required
                                    />
                                <label for="UsuarioLogin">USUARIO</label>
                            </div>
                            <div class="form-floating">
                                <input
                                    type="password"
                                    class="form-control"
                                    id="ContrasenaLogin"
                                    placeholder="Password"
                                    name="contrasenaLogin"
                                    required
                                    />
                                <label for="ContrasenaLogin">CONTRASEÑA</label>
                            </div>
                            <div class="modal-footer d-flex justify-content-center">
                                <button type="submit" class="btn text-white" id="sesion">INICIAR SESIÓN</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <div class="modal fade" id="exampleModaltwo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content" id="modal">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5 d-flex justify-content-center" id="exampleModalLabel">
                            <i class="bi bi-person-circle"></i> CREAR CUENTA
                        </h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="Registro" method="post" onsubmit="return validarRegistro()">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="UsuarioRegistro" name="usuario" placeholder="Usuario" required>
                                <label for="UsuarioRegistro">Usuario (Ejemplo: Manoli)</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" id="ContrasenaRegistro" name="contrasena" placeholder="Contraseña" required>
                                <label for="ContrasenaRegistro">Contraseña (Ejemplo: 3050BcEt.)</label>
                            </div>
                            <div class="form-floating">
                                <input type="email" class="form-control" id="Email" name="email" placeholder="Email" required>
                                <label for="Email">Email (Ejemplo: ejemplo@gmail.com)</label>
                            </div>
                            <button class="dropdown-item botonesSesion" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                Ya tienes cuenta?
                            </button>
                            <div class="modal-footer d-flex justify-content-center">
                                <button type="submit" class="btn text-white" id="sesion">CREAR CUENTA</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>      

        <section>


            <article id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="7000">
                        <img src="imagenes/18.jpg" class="d-block w-100 foto1" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="7000">
                        <img src="imagenes/1.png" class="d-block w-100 foto1" alt="...">
                    </div>
                    <div class="carousel-item " data-bs-interval="7000">
                        <img src="imagenes/25.jpg" class="d-block w-100 foto1" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </article>

            <article class="container text-center mt-5">
                <div class="row">
                    <div class="col mt-3 titulo">
                        Experiencia y compromiso en nuestro sector
                    </div>
                    <div class="col mt-5 texto">
                        En Servicios Agricarrión contamos con un equipo de profesionales con
                        años de experiencia en el sector de la agricultura que garantizan un
                        trabajo bien hecho y de calidad. Realizamos labores agrícolas
                        variadas para propietarios de fincas y empresas del sector de la
                        energía fotovoltaica.
                    </div>
                </div>
                <div class="row" id="conocenos">
                    <div class="col">
                        <a href="conocenos.jsp">
                            <button type="button" class="boton">CONOCENOS</button>
                        </a>
                    </div>
                    <div class="col"></div>
                </div>
            </article>

            <article class="d-flex justify-content-around text-center mt-5">
                <div class="row gap-5 w-100">
                    <div class="col d-flex justify-content-center">
                        <a href="labores.html">
                            <div class="card">
                                <img src="imagenes/3.jpg" class="card-img-top" alt="..." />
                                <div class="card-body d-flex align-items-center">
                                    <h5 class="card-title">
                                        Preparación de las tierras para sembrar y abonar
                                    </h5>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col d-flex justify-content-center">
                        <a href="labores.html">
                            <div class="card">
                                <img src="imagenes/23.jpg" class="card-img-top" alt="..." />
                                <div class="card-body d-flex align-items-center">
                                    <h5 class="card-title">
                                        Maquinaria agrícola para la cosecha
                                    </h5>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col d-flex justify-content-center">
                        <a href="nivelacion.html">
                            <div class="card">
                                <img src="imagenes/34.jpg" class="card-img-top" alt="..." />
                                <div class="card-body d-flex align-items-center">
                                    <h5 class="card-title">
                                        Preparación del terreno para la instalación de placas
                                        fotovoltaicas
                                    </h5>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </article>
        </section>

        <footer id="footer">
            <div class="text-center text-white pt-3">
                <div class="row" id="contenedor2">
                    <div class="col mt-5">
                        <h3>Contacta con nosotros</h3>
                        <h4>Dirección:</h4>
                        <p>Calle de la Anguila, 24 41200, Alcalá del Río (Sevilla)</p>
                        <h4>Teléfono:</h4>
                        <a
                            id="correoElc"
                            href="callto:605 698 429"
                            class="d-flex justify-content-center"
                            >605 698 429</a
                        >
                        <h4>Correo:</h4>
                        <a
                            id="correoElc"
                            href="mailto:agricarrion2018@gmail.com"
                            class="d-flex justify-content-center"
                            >agricarrion2018@gmail.com</a
                        >
                    </div>
                    <div class="col ratio ratio-4x3">
                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3164.84635990658!2d-5.99014332423705!3d37.511541672052836!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd12418b9bdeea2f%3A0xe3e392b7169e87a5!2sC.%20de%20la%20Anguila%2C%2024%2C%2024%2C%2041200%20Alcal%C3%A1%20del%20R%C3%ADo%2C%20Sevilla!5e0!3m2!1ses!2ses!4v1707929728148!5m2!1ses!2ses"
                            style="border: 0"
                            allowfullscreen=""
                            loading="lazy"
                            referrerpolicy="no-referrer-when-downgrade"
                            ></iframe>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
<script src="js/validacionRegistro.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<%
    HttpSession sesion = request.getSession();
    Boolean registroExitoso = (Boolean) sesion.getAttribute("registroExitoso");
    if (registroExitoso != null && registroExitoso) {
%>
<script>
                            Swal.fire({
                                icon: 'success',
                                title: '¡Registro exitoso!',
                                text: 'Tu cuenta ha sido creada correctamente.',
                                showConfirmButton: true
                            });
</script>
<%
        session.removeAttribute("registroExitoso");
    }
%>


<%
    Usuarios usuario = (Usuarios) sesion.getAttribute("usuario");
    Boolean error = (Boolean) sesion.getAttribute("error");
    Boolean login = (Boolean) sesion.getAttribute("login");
    if (usuario != null) {
%>
<script>
    let parrafoUsuario = document.getElementById("ParrafoUsuario");
    parrafoUsuario.innerHTML = '<%= usuario.getNombre()%>';
    parrafoUsuario.style.display = "block";
    parrafoUsuario.style.marginTop = "10px";
    let gestion = document.getElementById("gestion");
    gestion.style.display = "block";
</script>
<%
    if (login != null) {
%>
<script>
    Swal.fire({
        icon: 'success',
        title: '¡Login exitoso!',
        text: 'Usuario logueado correctamente.',
        showConfirmButton: true
    });
</script>

<%
    } session.removeAttribute("login");
} else if (error != null) {


%>
<script>
    Swal.fire({
        icon: 'error',
        title: '¡No se pudo loguear!',
        text: 'Usuario no registrado.',
        showConfirmButton: true
    });
</script>
<%  session.removeAttribute("error");  }
%>
