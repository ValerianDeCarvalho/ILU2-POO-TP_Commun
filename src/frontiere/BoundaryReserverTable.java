package frontiere;

import control.ControlReserverTable;
import model.Client;
import java.util.Scanner;

public class BoundaryReserverTable {
	private ControlReserverTable controlReserverTable;
	private Scanner scanner = new Scanner(System.in);
	
	public BoundaryReserverTable(ControlReserverTable controlReserverTable) {
		this.controlReserverTable = controlReserverTable;
	}
	
	public void reserverTable(int numClient) {
        System.out.print("Quand souhaitez vous reservez ? ");
        System.out.print("Pour quel mois ? ");
        int mois = scanner.nextInt();
        System.out.print("Pour quel jour ? ");
        int jour = scanner.nextInt();
        System.out.print("Pour combien de personnes ? ");
        int nombrePersonnes = scanner.nextInt();
        System.out.print("Pour quel service ? "); 
        int numService = scanner.nextInt();
        
        // Recherche des disponibilit�s
        int[] possibilites = controlReserverTable.trouverPossibilite(jour, mois, nombrePersonnes, numService);
        int numeroFormulaire = possibilites[0];
        
        System.out.println("Tables disponibles :");
        boolean hasDisponibilites = false;
        for (int i = 1; i < possibilites.length; i++) {
             System.out.println("- Table " + i); 
             hasDisponibilites = true;
        }

        if (!hasDisponibilites) {
            System.out.println("D�sol�, aucune table disponible.");
            return;
        }

        // Choix de l'utilisateur
        System.out.print("Entrez le num�ro de la table choisie : ");
        int choix = scanner.nextInt();

        // Effectue la r�servation
        controlReserverTable.reserver(numClient, choix, numeroFormulaire);
        System.out.println("R�servation confirm�e !");
    }
	
}