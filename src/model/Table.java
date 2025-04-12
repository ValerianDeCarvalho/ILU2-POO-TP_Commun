package model;

public class Table {
    private int numero;
    private int nbChaises;
    private boolean[] premierService;  // Ex: tableau de dates
    private boolean[] deuxiemeService; // Simplifié pour l'exemple

    public Table(int numero, int nbChaises) {
        this.numero = numero;
        this.nbChaises = nbChaises;
        this.premierService = new boolean[365]; // 365 jours/an
        this.deuxiemeService = new boolean[365];
    }

    public boolean estCompatible(FormulaireRestaurant formulaire) {
        // Vérification des chaises
        boolean chaisesOk = (nbChaises >= formulaire.getNombrePersonnes()) 
                          && (nbChaises <= formulaire.getNombrePersonnes() + 1);

        // Vérification de la disponibilité
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