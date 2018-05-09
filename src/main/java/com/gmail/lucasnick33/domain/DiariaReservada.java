package com.gmail.lucasnick33.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DiariaReservada extends Diaria {

    private static final long serialVersionUID = 1L;
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

}
