package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class EntiteReservable {
    protected int numero;
    protected List<LocalDate> reservations;

    protected EntiteReservable(int numero) {
        this.numero = numero;
        this.reservations = new ArrayList<>();
    }

    public boolean estLibre(LocalDate date) {
        return !reservations.contains(date);
    }

    public void reserver(LocalDate date) {
        reservations.add(date);
    }

    public int getNumero() {
        return numero;
    }
}