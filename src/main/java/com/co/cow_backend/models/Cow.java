package com.co.cow_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cow")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaca")
    private Integer idVaca;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "raza", length = 100, nullable = false)
    private String raza;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "nombre_mama", length = 50, nullable = false)
    private String nombreMama;
    @Column(name = "nombre_papa", length = 50, nullable = false)
    private String nombrePapa;
    @Column(name = "fecha_vacuna_aftosa", nullable = false)
    private Date fechaVacunaAftosa;
    @Column(name = "fecha_vacuna_brucelosis", nullable = false)
    private Date fechaVacunaBrucelosis;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

    public Date getFechaVacunaAftosa() {
        return fechaVacunaAftosa;
    }

    public void setFechaVacunaAftosa(Date fechaVacunaAftosa) {
        this.fechaVacunaAftosa = fechaVacunaAftosa;
    }

    public Date getFechaVacunaBrucelosis() {
        return fechaVacunaBrucelosis;
    }

    public void setFechaVacunaBrucelosis(Date fechaVacunaBrucelosis) {
        this.fechaVacunaBrucelosis = fechaVacunaBrucelosis;
    }

    public Integer getNumeroPartos() {
        return numeroPartos;
    }

    public void setNumeroPartos(Integer numeroPartos) {
        this.numeroPartos = numeroPartos;
    }
}
