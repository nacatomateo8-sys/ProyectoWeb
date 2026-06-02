package com.tienda.nueva.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionController {

    // Único encargado de responder a la página de inicio raíz
    @GetMapping("/")
    public String index() {
        return "index"; // Renderiza templates/index.html
    }

    @GetMapping("/catalogo")
    public String catalogo() {
        return "catalogo"; // Renderiza templates/catalogo.html
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        // Se mantiene "nostros" respetando el nombre exacto de tu archivo HTML
        return "nostros"; // Renderiza templates/nostros.html
    }

    @GetMapping("/ubicacion")
    public String ubicacion() {
        return "ubicacion"; // Renderiza templates/ubicacion.html
    }
}