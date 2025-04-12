package model;

public class FormulaireRestaurant extends Formulaire {
    private int numeroService;
    private int nombrePersonnes;

    public FormulaireRestaurant(int jour, int mois, int nombrePersonnes, int numeroService) {
        super(jour, mois);
        this.numeroService = numeroService;
        this.nombrePersonnes = nombrePersonnes;
    }

    public int getNumService() { return numeroService; }
    public int getNombrePersonnes() { return nombrePersonnes; }
}