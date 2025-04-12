package model;

public class Restaurant {
    private CentraleDeReservation<Table, FormulaireRestaurant> centrale;
    private int dernierNumeroTable = 0;

    public Restaurant() {
        this.centrale = new CentraleDeReservation<>();
    }

    public int ajouterTable(int nbChaises) {
        Table nouvelleTable = new Table(++dernierNumeroTable, nbChaises);
        centrale.ajouterEntite(nouvelleTable);
        return dernierNumeroTable;
    }

    public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
        return centrale.donnerPossibilites(formulaire);
    }

    public ReservationRestaurant reserver(int numeroTable, FormulaireRestaurant formulaire) {
        formulaire.setNumeroEntite(numeroTable);
        return centrale.reserver(numeroTable, formulaire);
    }
}
