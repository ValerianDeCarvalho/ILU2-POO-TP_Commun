package model;

public class ReservationRestaurant extends Reservation {
	private int numeroService;
    private int numeroTable;
    
    public ReservationRestaurant(int jour, int mois, int numeroService, int numeroTable) {
        super(jour, mois);
        this.numeroService = numeroService;
        this.numeroTable = numeroTable;
    }

    @Override
    public String toString() {
    	String service = (numeroService == 1) ? "premier" : "deuxième";
    	return String.format("Le %d/%d\nTable %d pour le %s service.", jour, mois, numeroTable, service);
    }
    
}