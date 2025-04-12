package model;

public class ReservationHotel extends Reservation {
	private int litsSimples;
    private int litsDoubles;
    private int numeroChambre;
    
    public ReservationHotel(int jour, int mois, int litsSimples, int litsDoubles, int numeroChambre) {
        super(jour, mois);
        this.litsSimples = litsSimples;
        this.litsDoubles = litsDoubles;
        this.numeroChambre = numeroChambre;
    }

    @Override
    public String toString() {
        String detailsLits = "";
        if (litsSimples > 0) {
            detailsLits += litsSimples + " lit" + (litsSimples > 1 ? "s simples" : " simple");
        }
        if (litsDoubles > 0) {
            if (!detailsLits.isEmpty()) detailsLits += ", ";
            detailsLits += litsDoubles + " lit" + (litsDoubles > 1 ? "s doubles" : " double");
        }
        return String.format("Le %d/%d : chambre n°%d (%s)", jour, mois, numeroChambre, detailsLits);
    }
}