package com.jobmatch.backend.model;

import jakarta.persistence.*;

@Entity // Esto le dice a Spring que esta clase es una tabla en la BD
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreEmpresa;

    private String direccion;

    @Column(nullable = false)
    private String correo;

    private String telefono;

    @Column(length = 500) // Descripción más larga
    private String descripcion;

    // CONSTRUCTORES
    public Empresa() {
    }

    public Empresa(String nombreEmpresa, String direccion, String correo, String telefono, String descripcion) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}