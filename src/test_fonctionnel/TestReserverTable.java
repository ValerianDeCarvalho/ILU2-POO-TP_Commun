package test_fonctionnel;

import control.ControlConnecterClient;
import control.ControlCreerClient;
import control.ControlReserverTable;
import frontiere.BoundaryConnecterClient;
import frontiere.BoundaryCreerClient;
import frontiere.BoundaryReserverTable;
import model.*;

public class TestReserverTable {
	public static void main(String[] args) {
		System.out.println("---------- CREER CLIENT ----------");
		// ENTITE : Creation du carnet de clientele
		CarnetClientele carnetClientele = new CarnetClientele();
		//

		ControlCreerClient controlCreerClient = new ControlCreerClient(carnetClientele);
		BoundaryCreerClient boundaryCreerClient = new BoundaryCreerClient(controlCreerClient);
		boundaryCreerClient.creerClient();

		System.out.println("\n---------- CONNECTER CLIENT ----------");
		ControlConnecterClient controlConnecterClient = new ControlConnecterClient(carnetClientele);
		BoundaryConnecterClient boundaryConnecterClient = new BoundaryConnecterClient(controlConnecterClient);
		int numClient = boundaryConnecterClient.connecterClient();
		
		Restaurant restaurant = new Restaurant();
		restaurant.ajouterTable(4);
		restaurant.ajouterTable(4);
	    restaurant.ajouterTable(2); 
	    restaurant.ajouterTable(6); 
		ControlReserverTable controlReserverTable = new ControlReserverTable(restaurant, carnetClientele.getClients());
		BoundaryReserverTable boundaryReserverTable = new BoundaryReserverTable(controlReserverTable);
		
		System.out.println("\n\n---------- Réservation de table ----------");
		boundaryReserverTable.reserverTable(numClient);

		System.out.println("\n\n---------- CONTROLE DES DONNEES ----------");
		System.out.println("Création du client n°" + numClient);
		System.out.println(carnetClientele);
	
	}
}
