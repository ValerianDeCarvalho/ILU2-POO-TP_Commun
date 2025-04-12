package model;

public class Restaurant {
    private CentraleReservation<Table, FormulaireRestaurant, ReservationRestaurant> centrale;
    private int dernierNumeroTable = 0;

    public Restaurant() {
        this.centrale = new CentraleReservation<>() {
            @Override
            public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
                int[] possibilites = new int[entites.size()];
                for (int i = 0; i < entites.size(); i++) {
                    Table table = entites.get(i);
                    possibilites[i] = table.estCompatible(formulaire) ? (i + 1) : 0;
                }
                return possibilites;
            }

            @Override
            public ReservationRestaurant reserver(int numeroEntite, FormulaireRestaurant formulaire) {
                Table table = entites.get(numeroEntite - 1);
                formulaire.setIdentificationEntite(numeroEntite);
                return table.reserver(formulaire); // Retourne directement ReservationRestaurant
            }
        };
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
        return centrale.reserver(numeroTable, formulaire);
    }
}