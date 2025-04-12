package model;
import java.util.ArrayList;
import java.util.List;

public abstract class CentraleReservation <E, F extends Formulaire, R extends Reservation> {
    protected List<E> entites;
    protected int nombreEntites;

    public CentraleReservation() {
        this.entites = new ArrayList<>();
        this.nombreEntites = 0;
    }

    public int ajouterEntite(E entite) {
        entites.add(entite);
        return ++nombreEntites;
    }

    public abstract int[] donnerPossibilites(F formulaire);

    public abstract R reserver(int numeroEntite, F formulaire);
    
}