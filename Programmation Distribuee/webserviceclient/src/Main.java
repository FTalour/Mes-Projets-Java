import fr.polytech.ws.Envoi;
import fr.polytech.ws.EnvoiService;
import fr.polytech.ws.ExceptionArticle_Exception;



public class Main {

	public static void main(String args[]){
		EnvoiService service = new EnvoiService();
		Envoi port = service.getEnvoiPort();
		int numCli = port.getNewPanier();
		
		System.out.println("Bonjour, voici notre catalogue du mois de Mars :\n"+port.viewCatalogue(numCli));
		
		try {
			port.ajouterPanier(numCli, 2);
			port.modifierPanier(numCli, 2, 3);
			System.out.println(port.afficherCommande(numCli));
			
		} catch (ExceptionArticle_Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
