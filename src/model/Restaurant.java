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
                return table.reserver(formulaire);
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

    // Classe interne Table
    private class Table {
        private int numero;
        private int nbChaises;
        private boolean[] premierService;
        private boolean[] deuxiemeService;

        public Table(int numero, int nbChaises) {
            this.numero = numero;
            this.nbChaises = nbChaises;
            this.premierService = new boolean[365];
            this.deuxiemeService = new boolean[365];
        }

        public boolean estCompatible(FormulaireRestaurant formulaire) {
            boolean chaisesOk = (nbChaises >= formulaire.getNombrePersonnes())
                    && (nbChaises <= formulaire.getNombrePersonnes() + 1);
            int jour = formulaire.getJour();
            return chaisesOk && (formulaire.getNumService() == 1
                    ? !premierService[jour]
                    : !deuxiemeService[jour]);
        }

        public ReservationRestaurant reserver(FormulaireRestaurant formulaire) {
            int jour = formulaire.getJour();
            if (formulaire.getNumService() == 1) {
                premierService[jour] = true;
            } else {
                deuxiemeService[jour] = true;
            }
            return new ReservationRestaurant(
                    formulaire.getJour(),
                    formulaire.getMois(),
                    formulaire.getNumService(),
                    this.numero
            );
        }
    }
}