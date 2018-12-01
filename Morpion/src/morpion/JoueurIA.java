package morpion;

import java.util.Random;

public class JoueurIA extends JoueurGenerique {

	/**
	 * constructeur d'un JoueurIA
	 * 
	 * @param nom
	 *            : nom de l'IA
	 * @param numero
	 *            : numero de l'IA
	 */
	public JoueurIA(String nom, int numero) {
		super(nom, numero);
	};

	/**
	 * tour de JoueurIA prend le jeu en parametre pour verifier que la case
	 * choisi n'est pas deja occupee
	 * 
	 * @param
	 */
	@Override
	public int[] tourJoueur(Jeu jeu) {
		int[] choix = { -1, -1 };

		do {
			Random rand = new Random();
			int nombreAleatoire1 = rand.nextInt(3);
			int nombreAleatoire2 = rand.nextInt(3);

			choix[0] = nombreAleatoire1;
			choix[1] = nombreAleatoire2;
		} while (jeu.occupee(choix));

		StringBuilder sb = new StringBuilder();
		sb.append("<<< ");
		sb.append(choix[1] + 1);
		sb.append(" ");
		sb.append(choix[0] + 1);
		System.out.println(sb.toString());

		return choix;
	};

}