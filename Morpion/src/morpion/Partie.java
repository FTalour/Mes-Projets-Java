package morpion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partie {
	/**
	 * converti les entrées clavier en string
	 * 
	 * @return
	 */
	static String lireConsole() {
		BufferedReader rea = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			String lu = rea.readLine();
			return lu;
		} catch (IOException e) {
			e.printStackTrace();
			return "erreur de lecture";
		}
	}

	/**
	 * Programme principale lancant une partie de morpion
	 */
	public static void main(String[] args) {
		String nomJoueur1;
		String nomJoueur2;

		System.out.print("Nom joueur 1 (ou 'IA') :\n");
		nomJoueur1 = lireConsole();

		do {
			System.out.print("Nom joueur 2 (ou 'IA') :\n");
			nomJoueur2 = lireConsole();
		} while (nomJoueur2.equals(nomJoueur1) && !nomJoueur2.equals("IA"));

		Jeu maPartie = new Jeu(nomJoueur1.toString(), nomJoueur2.toString());
		maPartie.jouerJeu();
	};
}
