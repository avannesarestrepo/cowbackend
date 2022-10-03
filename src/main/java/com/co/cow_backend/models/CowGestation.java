package com.co.cow_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cow")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CowGestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso_gestacion_vaca")
    private Integer idProcesoGestacionVaca;
    @Column(name = "id_vaca", length = 50, nullable = false)
    private Integer idVaca;
    @Column(name = "fecha_celo")
    private Date fechaCelo;
    @Column(name = "fecha_Inseminacion")
    private Date fechaInseminacion;
    @Column(name = "fecha_parto")
    private Date fechaParto;
    @Column(name = "fecha_secado")
    private Date fechaSecado;

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

    public Date getFechaCelo() {
        return fechaCelo;
    }

    public void setFechaCelo(Date fechaCelo) {
        this.fechaCelo = fechaCelo;
    }

    public Date getFechaInseminacion() {
        return fechaInseminacion;
    }

    public void setFechaInseminacion(Date fechaInseminacion) {
        this.fechaInseminacion = fechaInseminacion;
    }

    public Date getFechaParto() {
        return fechaParto;
    }

    public void setFechaParto(Date fechaParto) {
        this.fechaParto = fechaParto;
    }

    public Date getFechaSecado() {
        return fechaSecado;
    }

    public void setFechaSecado(Date fechaSecado) {
        this.fechaSecado = fechaSecado;
    }
}
