<%-- 
    Document   : anadirParcela
    Created on : 25 mar 2024, 18:16:04
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <a class="navbar-brand" id="titulo" href="index.html"
                       >SERVICIOSAGRICARRIÓN 2018
                        <img id="logo" src="../imagenes/download-removebg-preview (1).png" alt="logo" />
                    </a>

                </div>
            </nav>
        </header>

        <div class="container">
            <h2>Formulario de Gestión de petición</h2>
            <form action="GestionPeticion" method="post" onsubmit="return validarPeticionServicio()">
                <input type="hidden" name="id" value="${trabajo.id}"> 
                <div class="form-group">
                    <label for="servicio">Servicio:</label>
                    <input type="text" id="servicio" name="servicio" value="${trabajo.servicio.nombre}" readonly required >
                </div>
                <div class="form-group">
                    <label for="cliente">Cliente:</label>
                    <input type="text" id="cliente" name="cliente" value="${trabajo.cliente.nombre}" readonly required>
                </div>            
                <div class="form-group">
                    <label>Parcelas:</label>
                    <ul>    
                        <c:forEach var="parcela" items="${trabajo.parcela}">
                            <li>${parcela.nombre}</li>
                            </c:forEach>
                    </ul>
                </div>
                <div class="form-group">
                    <label for="base">Precio base:</label>
                    <input type="number" id="base" name="base" value="${trabajo.precioBase}" readonly required>
                </div>  
                <div class="form-group">
                    <label for="especifico">Precio específico:</label>
                    <input type="number" id="especifico" name="especifico" value="${trabajo.precioEspecifico}" step="0.1" min="0.0" required>
                </div> 
                <div class="form-group">
                    <label for="observaciones" >Observaciones:</label>
                    <textarea id="observaciones" name="observaciones" rows="4" cols="173">${trabajo.observaciones}</textarea>
                </div>
                <div class="form-group">
                    <label for="fecha" >Fecha realización:</label>
                    <input type="date" id="fecha" name="fecha" value="${trabajo.fechaRealizacion}">
                </div>
                <div class="form-group">
                    <label for="maquinaria" >Maquinaria:</label>
                    <select name="maquinaria[]" id="maquinaria" multiple>
                        <option value="seleccione" >Seleccione</option>
                        <c:forEach var="maquina" items="${maquinaria}">
                            <c:choose>
                                <c:when test="${maquinariaTrabajo.contains(maquina)}">
                                    <option value="${maquina.id}" selected>${maquina.nombre}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${maquina.id}">${maquina.nombre}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" value="Aceptar trabajo">
                </div>
            </form>
            <div class="form-group d-flex justify-content-center">
                <a href="GestionServicios">
                    <button type="button" class="boton">Cancelar</button>
                </a>
            </div>
        </div>
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
<script src="../js/validacionRegistro.js"></script>