const patronNombre = /^[A-Za-z]+(?: [A-Za-z]+)*$/;
const patronContraseña = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\-={}\[\]:;<>?,./])[A-Za-z\d!@#$%^&*()_+\-={}\[\]:;<>?,./]{8,20}$/;
const patronEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const patronLocalizacion = /^[A-Z][a-zA-Z\s-]+$/;
const patronTamano = /^\d+(\.\d+)?$/;
const patronPrecio = /^\d+(\.\d{1,2})?$/;


function validarRegistro() {
    let validado = true;
    let StringError = "";
    let nombre = document.getElementById("UsuarioRegistro").value;
    console.log(nombre);
    if (nombre === "" || !patronNombre.test(nombre)) {
        validado = false;
        StringError = "El Usuario debe estar compuesto por una mayúscula seguido de minúsculas\n";
    }
    let contraseña = document.getElementById("ContrasenaRegistro").value;
    if (contraseña.length === 0 || !patronContraseña.test(contraseña)) {
        validado = false;
        StringError += "La contraseña debe contener al menos 8 caracteres, 1 mayúcula, 1 minúscula, 1 dígito, 1 carácter especial\n";
    }
    let email = document.getElementById("Email").value;
    if (email.length === 0 || !patronEmail.test(email)) {
        validado = false;
        StringError += "El email debe ser válido";
    }

    if (!validado) {
        // Utiliza SweetAlert para mostrar el mensaje de error
        Swal.fire({
            icon: 'error',
            title: 'Error de validación',
            text: StringError
        });
    }
    return validado;
}

function validarLogin() {
    let validado = true;
    let StringError = "";
    let nombre = document.getElementById("UsuarioLogin").value;
    if (nombre === "" || !patronNombre.test(nombre)) {
        validado = false;
        StringError = "El Usuario debe estar compuesto por una mayúscula seguido de minúsculas\n";
    }
    let contraseña = document.getElementById("ContrasenaLogin").value;
    if (contraseña.length === 0 || !patronContraseña.test(contraseña)) {
        validado = false;
        StringError += "La contraseña debe contener al menos 8 caracteres, 1 mayúcula, 1 minúscula, 1 dígito, 1 carácter especial\n";
    }
    if (!validado) {
        // Utiliza SweetAlert para mostrar el mensaje de error
        Swal.fire({
            icon: 'error',
            title: 'Error de validación',
            text: StringError
        });
    }
    return validado;
}

function validarParcela() {
    let validado = true;
    let StringError = "";
    let nombre = document.getElementById("nombreParcela").value;
    if (nombre === "" || !patronNombre.test(nombre)) {
        validado = false;
        StringError = "El Nombre debe estar compuesto por una mayúscula seguido de minúsculas\n";
    }
    let localizacion = document.getElementById("localizacionParcela").value;
    if (localizacion.length === 0 || !patronLocalizacion.test(localizacion)) {
        validado = false;
        StringError += "La localización debe comenzar por mayúscula";
    }
    let tamano = document.getElementById("tamanoParcela").value;
    if (tamano.length === 0 || !patronTamano.test(tamano)) {
        validado = false;
        StringError += "El tamaño debe ser un número decimal";
    }
    if (!validado) {
        // Utiliza SweetAlert para mostrar el mensaje de error
        Swal.fire({
            icon: 'error',
            title: 'Error de validación',
            text: StringError
        });
    }
    return validado;
}

function confirmarEliminacion() {
    let confirmar = confirm("Seguro que quieres eliminarla?");
    return confirmar;
}

function validarTrabajo() {
    var selectParcelas = document.getElementById("parcelasSeleccionadas");
    var opcionesSeleccionadas = selectParcelas.selectedOptions;
    var seleccionadas = [];
    for (var i = 0; i < opcionesSeleccionadas.length; i++) {
        seleccionadas.push(opcionesSeleccionadas[i].value);
        if (!opcionesSeleccionadas[i].value || isNaN(opcionesSeleccionadas[i].value)) {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Por favor, seleccione al menos una parcela válida.'
            });
            return false;
        }
    }
    if (seleccionadas.length === 0 || seleccionadas.includes("")) {
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Por favor, seleccione al menos una parcela.'
        });
        return false;
    }
    return true;
}

function validarServicio() {
    let validado = true;
    let StringError = "";

    let nombre = document.getElementById("nombreServicio").value;
    if (nombre === "" || !patronNombre.test(nombre)) {
        validado = false;
        StringError = "El nombre solo puede contener letras y espacios.\n";
    }

    let precio = document.getElementById("precio").value;
    if (precio === "" || !patronPrecio.test(precio)) {
        validado = false;
        StringError += "El precio debe ser un número decimal.\n";
    }

    let fichero = document.getElementById("fichero").value;
    if (fichero === "") {
        validado = false;
        StringError += "Debes seleccionar un fichero.\n";
    } else {
        let extension = fichero.substring(fichero.lastIndexOf('.') + 1).toLowerCase();
        if (extension !== "png" && extension !== "jpg" && extension !== "jpeg") {
            validado = false;
            StringError += "El fichero debe ser de tipo PNG, JPG o JPEG.\n";
        }
    }

    if (!validado) {
        Swal.fire({
            icon: 'error',
            title: 'Error de validación',
            text: StringError
        });
    }

    return validado;
}
