package com.co.cow_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cow")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class    Cow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaca")
    private Integer idVaca;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "raza", length = 100, nullable = false)
    private String raza;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(name = "nombre_mama", length = 50, nullable = false)
    private String nombreMama;
    @Column(name = "nombre_papa", length = 50, nullable = false)
    private String nombrePapa;
    @Column(name = "fecha_vacuna_aftosa", nullable = false)
    private LocalDate fechaVacunaAftosa;
    @Column(name = "fecha_vacuna_brucelosis", nullable = false)
    private LocalDate fechaVacunaBrucelosis;
    @Column(name = "numero_partos", nullable = false)
    private Integer numeroPartos;

    public Integer getIdVaca() {
        return idVaca;
    }

    public void setIdVaca(Integer idVaca) {
        this.idVaca = idVaca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreMama() {
        return nombreMama;
    }

    public void setNombreMama(String nombreMama) {
        this.nombreMama = nombreMama;
    }

    public String getNombrePapa() {
        return nombrePapa;
    }

    public void setNombrePapa(String nombrePapa) {
        this.nombrePapa = nombrePapa;
    }

    public LocalDate getFechaVacunaAftosa() {
        return fechaVacunaAftosa;
    }

    public void setFechaVacunaAftosa(LocalDate fechaVacunaAftosa) {
        this.fechaVacunaAftosa = fechaVacunaAftosa;
    }

    public LocalDate getFechaVacunaBrucelosis() {
        return fechaVacunaBrucelosis;
    }

    public void setFechaVacunaBrucelosis(LocalDate fechaVacunaBrucelosis) {
        this.fechaVacunaBrucelosis = fechaVacunaBrucelosis;
    }

    public Integer getNumeroPartos() {
        return numeroPartos;
    }

    public void setNumeroPartos(Integer numeroPartos) {
        this.numeroPartos = numeroPartos;
    }
}
