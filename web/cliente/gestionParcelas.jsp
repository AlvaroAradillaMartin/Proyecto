<%-- 
    Document   : gestionParcelas
    Created on : 25 mar 2024, 16:17:14
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="../css/css.css" />
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
                    <a class="navbar-brand" id="titulo" href="../index.html"
                       >SERVICIOSAGRICARRIÓN 2018
                        <img id="logo" src="../imagenes/download-removebg-preview (1).png" alt="logo" />
                    </a>

                </div>
            </nav>
        </header>
        <section class="container text-center">
            <h1>Gestión de Parcelas</h1>
            <div class="d-flex justify-content-around">
                <a href="AnadirParcela">
                    <button class="boton">Añadir parcela</button>
                </a>
                <a href="Gestionar">
                    <button class="boton">Volver al Menú</button>
                </a>
            </div>
            <div class="table-responsive" >
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Localización</th>
                            <th>Tamaño</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="parcela" items="${parcelas}">
                            <tr>
                                <td>${parcela.nombre}</td>
                                <td>${parcela.localizacion}</td>
                                <td>${parcela.tamano}</td>
                                <td class="d-flex justify-content-center"> <a href="EditarParcela?id=${parcela.id}"> <button class="boton">Editar</button> </a> 
                                    <form action="EliminarParcela?id=${parcela.id}" method="post" onsubmit="return confirmarEliminacion(event)">
                                        <input class="boton" type="submit" value="Eliminar">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
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
<script src="../js/validacionRegistro.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<%
    HttpSession sesion = request.getSession();
    Boolean eliminacionExitoso = (Boolean) sesion.getAttribute("eliminado");
    if (eliminacionExitoso != null && eliminacionExitoso) {
%>
<script>
                                        Swal.fire({
                                            icon: 'success',
                                            title: '¡Eliminación exitosa!',
                                            text: 'Se ha eliminado la parcela correctamente.',
                                            showConfirmButton: true
                                        });
</script>
<%
} else if (eliminacionExitoso != null && !eliminacionExitoso) {


%>
<script>
    Swal.fire({
        icon: 'error',
        title: '¡Eliminación fallida!',
        text: 'Se ha podido eliminadar la parcela correctamente.',
        showConfirmButton: true
    });
</script>

<%    }
    session.removeAttribute("eliminado");
%>