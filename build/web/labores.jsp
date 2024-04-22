<%-- 
    Document   : labores
    Created on : 19 mar 2024, 19:16:39
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                                   >SERVICIOS AGRIOLAS</a
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
                        <div class="form-floating mb-3">
                            <input
                                type="text"
                                class="form-control"
                                id="floatingInput"
                                placeholder="name@example.com"
                                />
                            <label for="floatingInput">USUARIO</label>
                        </div>
                        <div class="form-floating">
                            <input
                                type="password"
                                class="form-control"
                                id="floatingPassword"
                                placeholder="Password"
                                />
                            <label for="floatingPassword">CONTRASEÑA</label>
                        </div>
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <button type="button" class="btn text-white" id="sesion">
                            INICIAR SESIÓN
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div
            class="modal fade"
            id="exampleModaltwo"
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
                            <i class="bi bi-person-circle"></i> CREAR CUENTA
                        </h1>
                        <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"
                            ></button>
                    </div>
                    <div class="modal-body">
                        <div class="form-floating mb-3">
                            <input
                                type="text"
                                class="form-control"
                                id="floatingInput"
                                placeholder="name@example.com"
                                />
                            <label for="floatingInput">NOMBRE</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input
                                type="text"
                                class="form-control"
                                id="floatingInput"
                                placeholder="name@example.com"
                                />
                            <label for="floatingInput">USUARIO</label>
                        </div>
                        <div class="form-floating">
                            <input
                                type="password"
                                class="form-control"
                                id="floatingPassword"
                                placeholder="Password"
                                />
                            <label for="floatingPassword">CONTRASEÑA</label>
                        </div>
                        <button
                            class="dropdown-item botonesSesion"
                            type="button"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                            >
                            Ya tienes cuenta?
                        </button>
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <button type="button" class="btn text-white" id="sesion">
                            CREAR CUENTA
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <section>
            <article class="text-center titulo">Nuestros Servicios, Selecione el necesario.</article>
            <article class="d-flex justify-content-around text-center mt-5">
                <div class="row gap-5 w-100">

                    <c:forEach var="servicio" items="${servicios}">

                        <div class="col d-flex justify-content-center">
                            <a href="cliente/CrearTrabajo?id=${servicio.id}">
                                <div class="card">
                                    <img src="${servicio.imagen}" class="card-img-top" alt="..." />
                                    <div
                                        class="card-body d-flex align-items-center justify-content-center"
                                        >
                                        <h5 class="card-title text-center">${servicio.nombre}</h5>
                                    </div>
                                </div>
                            </a>
                        </div>

                    </c:forEach>

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

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<%
    HttpSession sesion = request.getSession();
    Boolean error = (Boolean) sesion.getAttribute("error");
    System.out.println("/////////////////////////////////////////////labores.jsp");
    System.out.println(error);
    if (error != null) {
        if (!error) {


%>
<script>
    Swal.fire({
        icon: 'success',
        title: '¡Registro exitoso!',
        text: 'Tu petición de servicio ha sido creada correctamente.',
        showConfirmButton: true
    });
</script>
<%} else {


%>
<script>
    Swal.fire({
        icon: 'error',
        title: '¡Registro fallido!',
        text: 'Ha ocurrido un error con tu petición de servicio.',
        showConfirmButton: true
    });
</script>
<%        }
        session.removeAttribute("error");
    }
%>