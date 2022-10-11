package com.co.cow_backend.utils;

import java.time.LocalDate;

public class EventsDTO {
    private Integer idNotification;
    private Integer idVaca;
    private String nombreVaca;
    private String nombreEvento;
    private LocalDate fechaEvento;
    private Boolean estado;

    public EventsDTO(Integer idNotification, Integer idVaca, String nombreVaca, String nombreEvento, LocalDate fechaEvento, Boolean estado) {
        this.idNotification = idNotification;
        this.idVaca = idVaca;
        this.nombreVaca = nombreVaca;
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

    public String getNombreVaca() {
        return nombreVaca;
    }

    public void setNombreVaca(String nombreVaca) {
        this.nombreVaca = nombreVaca;
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
