function validar2() {
    var nombre = document.getElementById("txtNombre");
    var apellidos = document.getElementById("txtApellidos");
    var telef = document.getElementById("txtTelef");
    var dni = document.getElementById("txtDNI");
    var usu = document.getElementById("txtUsuario");
    var pass1 = document.getElementById("txtPassword");
    var pass2 = document.getElementById("txtPassword1");

    if (nombre.value.length === 0 || apellidos.value.length === 0 || telef.value.length === 0
            || dni.value.length === 0 || usu.value.length === 0 || pass1.value.length === 0
            || pass2.value.length === 0) {
        window.alert("Complete todos los campos!");
        return false;
    } else if (isNaN(dni.value) || isNaN(telef.value)) {
        window.alert("Dni y telefono deben ser valores númericos!");
        return false;
    } else if (telef.value.length !== 9 || dni.value.length !== 8) {
        window.alert("Dni debe tener 8 digitos y Telefono 9!");
        return false;
    } else if (pass1.value !== pass2.value) {
        window.alert("Las contraseñas deben coincidir!");
        return false;
    } else {
        return confirm("¿Desea Guardar?");
    }
}

function revelar() {
    var pass1 = document.getElementById("txtPassword");
    var pass2 = document.getElementById("txtPassword1");
    var btn = document.getElementById("btnMostrar");
    if (pass1.getAttribute("type") === "password" ||
            pass2.getAttribute("type") === "password") {
        pass1.removeAttribute("type");
        pass1.setAttribute("type", "text");
        pass2.removeAttribute("type");
        pass2.setAttribute("type", "text");
        btn.innerHTML = "";
        btn.appendChild(document.createTextNode("Ocultar"));
    } else {
        pass1.removeAttribute("type");
        pass1.setAttribute("type", "password");
        pass2.removeAttribute("type");
        pass2.setAttribute("type", "password");
        btn.innerHTML = "";
        btn.appendChild(document.createTextNode("Mostrar"));
    }
    btn.appendChild(document.createTextNode(" Contraseña"));
}

function validar1() {
    var usu = document.getElementById("txtUsuario");
    var pass = document.getElementById("txtPassword");
    if (usu.value.length === 0 || pass.value.length === 0) {
        window.alert("Complete todos los campos!");
        return false;
    } else {
        return true;
    }
}