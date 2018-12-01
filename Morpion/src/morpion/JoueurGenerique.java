package morpion;

/**
 * 
 * @author ftalou1 classe abstraite implémentant les méthodes qu'il est possible
 *         d'implémenter
 */
public abstract class JoueurGenerique implements Joueur {
	private String nomJoueur;
	private int numero;
	private char symbole;

	/**
	 * Constructeur de JoueurGenerique
	 * 
	 * @param nom
	 * @param numero
	 */
	JoueurGenerique(String nom, int numero) {
		nomJoueur = nom;
		this.numero = numero;
		if (numero == 1)
			symbole = 'O';
		else if (numero == 2)
			symbole = 'X';

		afficherJoueur();
	};

	/**
	 * renvoi le nom du joueur
	 */
	public String getNom() {
		return new String(nomJoueur);
	};

	/**
	 * renvoi le symbole associé au joueur
	 */
	public char getSymbole() {
		return symbole;
	};

	/**
	 * renvoi le numero associé au joueur
	 */
	public int getNumero() {
		return numero;
	};

	/**
	 * affiche le nom du joueur et ses caracteristiques
	 */
	public void afficherJoueur() {
		StringBuilder sb = new StringBuilder();
		sb.append("Joueur " + getNumero() + " : " + getNom() + " ("
				+ getClass() + ") " + "-> " + "'" + getSymbole() + "'");
		System.out.println(sb.toString());
	};

	/**
	 * permet au joueurs de jouer
	 */
	public abstract int[] tourJoueur(Jeu jeu);
}
