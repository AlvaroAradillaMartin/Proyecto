<%-- 
    Document   : anadirParcela
    Created on : 25 mar 2024, 18:16:04
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="http://localhost:8080/proyectoFinal/css/css.css">
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
                        <img id="logo" src="../imagenes/download-removebg-preview (1).png" alt="logo" />
                    </a>

                </div>
            </nav>
        </header>
        <section>
            <artcile class="container d-flex justify-content-center ">  
                <div  id="formulario" class="p-3">
                    <h1
                        class="fs-5 d-flex justify-content-center mb-3"
                        >
                        <i class="bi bi-person-circle"></i> INICIAR SESIÓN
                    </h1>
                    <form  action="http://localhost:8080/proyectoFinal/LoginAdmin" method="post" onsubmit="return validarLogin()">
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
                        <div class="d-flex justify-content-center mt-3">
                            <button type="submit" class="btn text-white" id="sesion">INICIAR SESIÓN</button>
                        </div>
                    </form>
                </div>
            </artcile>   
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
<script src="http://localhost:8080/proyectoFinal/js/validacionRegistro.js"></script>
<%
    HttpSession sesion = request.getSession();
    Boolean error = (Boolean) sesion.getAttribute("error");
    if (error != null) {
%>
<script>
    Swal.fire({
        icon: 'error',
        title: '¡No se pudo loguear!',
        text: 'Usuario no registrado o no Adminitrador.',
        showConfirmButton: true
    });
</script>
<%  }
 session.removeAttribute("error"); 
%>