package com.tienda.nueva.web.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class pedido {
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario_id", nullable = false)
    private int usuarioId; // Si tienes una entidad Usuario, cámbialo a @ManyToOne

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private String estado = "pendiente";

    @Lob
    private String notas;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detallepedido> detalles = new ArrayList<>();

    public pedido() {}

    public pedido(int usuarioId, double total, String estado, String notas) {
        this.usuarioId = usuarioId;
        this.total = total;
        this.estado = estado;
        this.notas = notas;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public List<Detallepedido> getDetalles() { return detalles; }
    public void setDetalles(List<Detallepedido> detalles) { this.detalles = detalles; }
}