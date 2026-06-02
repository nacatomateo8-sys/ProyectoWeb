package com.tienda.nueva.web.controller;

import com.tienda.nueva.web.model.carrito;
import com.tienda.nueva.web.service.CarritoModeloService;
import com.tienda.nueva.web.service.CarritoObservador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController implements CarritoObservador {

    @Autowired
    private CarritoModeloService carritoModelo;

    private List<carrito> productosVisuales;
    private BigDecimal totalVisual = BigDecimal.ZERO;

    @Autowired
    public void init() {
        carritoModelo.registrarObservador(this);
    }

    @Override
    public void mapearCambiosAVista(List<carrito> items, BigDecimal total) {
        this.productosVisuales = items;
        this.totalVisual = total;
    }

    @GetMapping("/carrito")
    public String verCarritoExamen(Model model) {
        this.productosVisuales = carritoModelo.getItems();
        this.totalVisual = carritoModelo.getTotal();

        model.addAttribute("carrito", this.productosVisuales);
        model.addAttribute("total", this.totalVisual);

        return "carrito"; 
    }

    @PostMapping("/agregar")
    public String agregarItem(@RequestParam int id, @RequestParam(defaultValue = "1") int cantidad) {
        carritoModelo.agregarProducto(id, cantidad);
        return "redirect:/pedido/carrito";
    }

    @GetMapping("/eliminar")
    public String eliminarItem(@RequestParam int index) {
        carritoModelo.eliminarProducto(index);
        return "redirect:/pedido/carrito";
    }

    @GetMapping("/vaciar")
    public String vaciarTodo() {
        carritoModelo.vaciarCarrito();
        return "redirect:/pedido/carrito";
    }
}