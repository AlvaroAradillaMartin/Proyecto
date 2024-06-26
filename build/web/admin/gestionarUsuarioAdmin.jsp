<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="http://localhost:8080/proyectoFinal/css/css.css" />
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
                       >SERVICIOSAGRICARRI�N 2018
                        <img id="logo" src="http://localhost:8080/proyectoFinal/imagenes/download-removebg-preview (1).png" alt="logo" />
                    </a>

                </div>
            </nav>
        </header>

        <section class="container">
            <h2>Editar Datos</h2>
            <form action="GestionarUsuarioAdmin" method="post" onsubmit="return validarRegistro()">
                <div class="form-group">
                    <input type="hidden" id="id" name="id" value="${usuario.id}">
                    <label for="UsuarioRegistro">Usuario:</label>
                    <input type="text" id="UsuarioRegistro" name="usuario" value="${usuario.nombre}" required>
                </div>
                <div class="form-group">
                    <label for="ContrasenaRegistro">Contrase�a:</label>
                    <input type="password" id="ContrasenaRegistro" name="contrasena" value="${usuario.contrasena}" required>
                </div>
                <div class="form-group">
                    <label for="Email">Correo:</label>
                    <input type="email" id="Email" name="correo" value="${usuario.correo}" required>
                </div>

                <div class="form-group d-flex justify-content-around">
                    <button type="submit">Editar</button>
                    <button class="boton">
                        <a href="GestionarParcelasAdmin?id=${usuario.id}">
                            Gestionar parcelas usuario ${usuario.nombre}
                        </a>
                    </button>
                    <button class="boton">
                        <a href="GestionarUsuarios">

                            Volver al Men�

                        </a>
                    </button>

                </div>
            </form>

        </section>

        <footer id="footer">
            <div class="text-center text-white pt-3">
                <div class="row" id="contenedor2">
                    <div class="col mt-5">
                        <h3>Contacta con nosotros</h3>
                        <h4>Direcci�n:</h4>
                        <p>Calle de la Anguila, 24 41200, Alcal� del R�o (Sevilla)</p>
                        <h4>Tel�fono:</h4>
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
<script src="http://localhost:8080/proyectoFinal/js/validacionRegistro.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>