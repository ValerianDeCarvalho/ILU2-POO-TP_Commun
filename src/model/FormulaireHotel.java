package model;

public class FormulaireHotel extends Formulaire {
	    private int litsSimples;
	    private int litsDoubles;

	    public FormulaireHotel(int jour, int mois, int litsSimples, int litsDoubles) {
	        super(jour, mois);
	        this.litsSimples = litsSimples;
	        this.litsDoubles = litsDoubles;
	    }

	    public int getLitsSimples() { 
	    	return litsSimples;
	    }
	    public int getLitsDoubles() {
	    	return litsDoubles;
	    }
}