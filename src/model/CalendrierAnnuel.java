package model;

public class CalendrierAnnuel {
    private Mois[] calendrier;
	
    public CalendrierAnnuel() {
        this.calendrier = new Mois[12];
        calendrier[0] = new Mois("Janvier", 31);
        calendrier[1] = new Mois("Février", 28);
        calendrier[2] = new Mois("Mars", 31);
        calendrier[3] = new Mois("Avril", 30);
        calendrier[4] = new Mois("Mai", 31);
        calendrier[5] = new Mois("Juin", 30);
        calendrier[6] = new Mois("Juillet", 31);
        calendrier[7] = new Mois("Août", 31);
        calendrier[8] = new Mois("Septembre", 30);
        calendrier[9] = new Mois("Octobre", 31);
        calendrier[10] = new Mois("Novembre", 30);
        calendrier[11] = new Mois("Décembre", 31);
    }
    
    public boolean estLibre(int jour, int mois) {
    	return calendrier[mois-1].estLibre(jour-1);
    }
    
    public boolean reserver(int jour, int mois) {
    	if (calendrier[mois-1].estLibre(jour-1)){
    		calendrier[mois-1].reserver(jour-1);
    		return true;
    	}
    	return false;
    }
    
	private static class Mois {
		private String nom;
		private boolean[] jour;
		
		public Mois(String nom, int nbJour) {
			this.nom = nom;
			this.jour = new boolean[nbJour];
            for (int i = 0; i < jour.length; i++) {
                jour[i] = true;
            }
		}
		
		private boolean estLibre(int x){
			if (x >= 0 && x < jour.length){
				return jour[x];
			}
			return false;
		}
		
		private void reserver(int x){
			if (x >= 0 && x < jour.length) {
				jour[x]=false;
			}
		}
	}
	
}
