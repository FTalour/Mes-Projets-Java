package morpion;

public class JoueurConsole extends JoueurGenerique {
	/**
	 * constructeur d'un JoueurConsole
	 * 
	 * @param nom
	 *            : nom du joueur
	 * @param numero
	 *            : numero du joueur
	 */
	public JoueurConsole(String nom, int numero) {
		super(nom, numero);
	};

	/**
	 * tour du JoueurConsole
	 * 
	 * @param
	 */
	@Override
	public int[] tourJoueur(Jeu jeu) {

		int choix[] = { -1, -1 };

		StringBuilder sb = new StringBuilder();
		sb.append("A " + getNom() + " (" + getClass() + ") " + "-> " + "'"
				+ getSymbole() + "' de jouer");
		System.out.println(sb.toString());

		// en faisant un do .. while en demandant d'entrer soit 1 soit 2 soit 3
		// on empêche les erreurs de conversion en entier
		String maLigne;
		do {
			System.out.print("ligne  : ");
			maLigne = Partie.lireConsole();
		} while (!maLigne.equals("1") && !maLigne.equals("2")
				&& !maLigne.equals("3"));
		choix[0] = Integer.parseInt(maLigne) - 1;

		String maColonne;
		do {
			System.out.print("colonne  : ");
			maColonne = Partie.lireConsole();
		} while (!maColonne.equals("1") && !maColonne.equals("2")
				&& !maColonne.equals("3"));

		choix[1] = Integer.parseInt(maColonne) - 1;

		return choix;
	};
}
