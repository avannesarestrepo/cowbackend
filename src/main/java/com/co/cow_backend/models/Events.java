package com.co.cow_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private Integer idNotification;
    @Column(name = "id_vaca")
    private Integer idVaca;
    @Column(name = "nombre_evento")
    private String nombreEvento;
    @Column(name = "fecha_evento", nullable = false)
    private LocalDate fechaEvento;
    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Events(){}
    public Events(Integer idVaca, String nombreEvento, LocalDate fechaEvento, Boolean estado) {
        this.idVaca = idVaca;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.estado = estado;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Integer getIdVaca() {
        return idVaca;
    }

    public void setIdVaca(Integer idVaca) {
        this.idVaca = idVaca;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
