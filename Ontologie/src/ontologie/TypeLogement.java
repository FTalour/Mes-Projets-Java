package ontologie;

/**
 * regroupe les differents types de logements existants
 * 
 * @author Florian
 *
 */
public enum TypeLogement {
	STUDIO("studio"), _2_PIECES("_2_pieces"), _3_PIECES("_3_pieces"), MAISON("maison");

	private final String aPourType;

	TypeLogement(String aPourType) {
		this.aPourType = aPourType;
	}

	public String getAPourType() {
		return aPourType;
	};
}
