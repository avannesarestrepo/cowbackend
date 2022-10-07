package com.co.cow_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cow_gestation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CowGestation {
    @Id
    @Column(name = "id_proceso_gestacion_vaca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcesoGestacionVaca;
    @Column(name = "id_vaca", length = 50, nullable = false)
    private Integer idVaca;
    @Column(name = "fecha_celo")
    private LocalDate fechaCelo;
    @Column(name = "fecha_Inseminacion")
    private LocalDate fechaInseminacion;
    @Column(name = "fecha_parto")
    private LocalDate fechaParto;
    @Column(name = "fecha_secado")
    private LocalDate fechaSecado;

    public Integer getIdProcesoGestacionVaca() {
        return idProcesoGestacionVaca;
    }

    public void setIdProcesoGestacionVaca(Integer idProcesoGestacionVaca) {
        this.idProcesoGestacionVaca = idProcesoGestacionVaca;
    }

    public Integer getIdVaca() {
        return idVaca;
    }

    public void setIdVaca(Integer idVaca) {
        this.idVaca = idVaca;
    }

    public LocalDate getFechaCelo() {
        return fechaCelo;
    }

    public void setFechaCelo(LocalDate fechaCelo) {
        this.fechaCelo = fechaCelo;
    }

    public LocalDate getFechaInseminacion() {
        return fechaInseminacion;
    }

    public void setFechaInseminacion(LocalDate fechaInseminacion) {
        this.fechaInseminacion = fechaInseminacion;
    }

    public LocalDate getFechaParto() {
        return fechaParto;
    }

    public void setFechaParto(LocalDate fechaParto) {
        this.fechaParto = fechaParto;
    }

    public LocalDate getFechaSecado() {
        return fechaSecado;
    }

    public void setFechaSecado(LocalDate fechaSecado) {
        this.fechaSecado = fechaSecado;
    }
}
