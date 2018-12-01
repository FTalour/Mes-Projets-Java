package morpion;

/**
 * Contient les classes representant une partie de morpion
 * 
 * @author Florian
 */
public class Jeu {
	Joueur joueur1, joueur2;
	char cases[][] = { { '?', '?', '?' }, { '?', '?', '?' }, { '?', '?', '?' } };
	int casesLibres = 9;

	/**
	 * initialise les deux joueurs
	 */
	public Jeu(String nomJoueur1, String nomJoueur2) {
		// initialise joueur1
		if (nomJoueur1.equals("IA")) {
			joueur1 = new JoueurIA("IA1", 1);
		} else
			joueur1 = new JoueurConsole(nomJoueur1, 1);

		// initialise joueur2
		if (nomJoueur2.equals("IA")) {
			joueur2 = new JoueurIA("IA2", 2);
		} else
			joueur2 = new JoueurConsole(nomJoueur2, 2);

	}

	public void jouerJeu() {

		dessinerCases();

		// les joueurs jouent jusqu'e ce qu'il n'y est plus de cases ou qu'un
		// des joueurs gagne
		while (!gagne() && casesLibres != 0) {
			int[] choix = null;

			boolean continuer = true;
			while (continuer) {
				// le joueur 2 joue quand c'est son tour
				if (casesLibres % 2 == 0) {
					choix = joueur2.tourJoueur(this);
					// on verifie si la case est occupee
					if (!occupee(choix)) {
						setCase(choix, joueur2);
						continuer = false;
					} else {
						messageCaseoccupee(choix);
					}

				} else {
					// le joueur 1 joue quand s'est son tour
					choix = joueur1.tourJoueur(this);
					// on verifie si la case est occupee
					if (!occupee(choix)) {
						setCase(choix, joueur1);
						continuer = false;
					} else {
						messageCaseoccupee(choix);
					}

				}
			}
			dessinerCases();

			casesLibres--;
		}

		victoire();
	}

	private void victoire() {
		/*
		 * verifie qui a gagne si il n'y a pas de gagnant alors il y a egalite
		 * sinon si le joueur 1 viens de jouer alors il reste un nombre pair de
		 * cases donc si il y a un gagnant c'est lui qui gagne sinon c'est le
		 * joueur 2 qui gagne
		 */
		if (!gagne())
			System.out.println("Egalite");
		else if (casesLibres % 2 == 0)
			System.out.println("Victoire du joueur : " + joueur1.getNom()
					+ " (" + joueur1.getClass() + ") " + "-> "
					+ joueur1.getSymbole());
		else
			System.out.println("Victoire du joueur : " + joueur2.getNom()
					+ " (" + joueur2.getClass() + ") " + "-> "
					+ joueur2.getSymbole());

	}

	/**
	 * met une case utilisee a la valeur du symbole du joueur utilisee
	 * 
	 * @param choix
	 * @param joueur
	 */
	private void setCase(int[] choix, Joueur joueur) {
		cases[choix[1]][choix[0]] = joueur.getSymbole();
	}

	/**
	 * affiche un message comme quoi la case utilisee est occupee
	 * 
	 * @param choix
	 */
	private void messageCaseoccupee(int[] choix) {
		StringBuilder sb = new StringBuilder();
		sb.append("La case : {");
		sb.append(choix[1] + 1);
		sb.append(",");
		sb.append(choix[0] + 1);
		sb.append("} est occupee.");
		System.out.println(sb.toString());
	}

	/**
	 * verifie si quelqu'un a gagne
	 * 
	 * @return vrai si quelqu'un a gagne faux sinon
	 */
	public boolean gagne() {
		// verifie les lignes
		if ((cases[0][0] == cases[0][1]) && (cases[0][0] == cases[0][2])
				&& cases[0][0] != '?')
			return true;
		else if ((cases[1][0] == cases[1][1]) && (cases[1][0] == cases[1][2])
				&& cases[1][0] != '?')
			return true;
		else if ((cases[2][0] == cases[2][1]) && (cases[2][0] == cases[2][2])
				&& cases[2][0] != '?')
			return true;

		// verifie les colonnes
		else if ((cases[0][0] == cases[1][0]) && (cases[0][0] == cases[2][0])
				&& cases[0][0] != '?')
			return true;
		else if ((cases[0][1] == cases[1][1]) && (cases[0][1] == cases[2][1])
				&& cases[0][1] != '?')
			return true;
		else if ((cases[0][2] == cases[1][2]) && (cases[0][2] == cases[2][2])
				&& cases[0][2] != '?')
			return true;

		// verifie les diagonales
		else if ((cases[0][0] == cases[1][1]) && (cases[0][0] == cases[2][2])
				&& cases[0][0] != '?')
			return true;
		else if ((cases[0][2] == cases[1][1]) && (cases[0][2] == cases[2][0])
				&& cases[0][2] != '?')
			return true;
		else
			return false;
	}

	/**
	 * Dessine les cases
	 */
	public void dessinerCases() {
		int i, j;
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				sb.append("|");
				sb.append(cases[j][i]);
			}
			sb.append("|\n");
		}
		System.out.println(sb.toString());
	}

	/**
	 * verifie que la case ou l'on joue n'est pas deja utilisee
	 * 
	 * @param choix
	 * @return vrai si la case est occupee et faux sinon
	 */
	public boolean occupee(int[] choix) {
		int x = choix[0];
		int y = choix[1];

		if (cases[y][x] == joueur1.getSymbole()
				|| cases[y][x] == joueur2.getSymbole())
			return true;
		else
			return false;
	}

}
